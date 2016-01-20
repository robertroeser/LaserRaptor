package laser.raptor;

import laser.raptor.antlr.generated.LaserRaptorLexer;
import laser.raptor.antlr.generated.LaserRaptorParser;
import laser.raptor.laser.raptor.antlr.LaserRaptorListener;
import laser.raptor.string_template.java.ClientServiceTemplate;
import laser.raptor.string_template.java.GuiceModuleTemplate;
import laser.raptor.string_template.java.MessageTemplate;
import laser.raptor.string_template.java.ServerServiceTemplate;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class LaserRaptor {
    private String input;
    private String output;
    private boolean server;
    private boolean guice;

    public LaserRaptor(String input, String output, boolean server) {
        this.input = input;
        this.output = output;
        this.server = server;

        System.out.println("Processing input file => " + input);
        System.out.println("Saving contents to output directory => " + output);

        File f = new File(input);
        System.out.println(f.exists());
    }

    public static void main(String... args) throws Exception {
        Options options = new Options();

        options.addOption("i", "input", true, "Laser Raptor idl input file");
        options.addOption("l", "language", true, "Language to generate source in");
        options.addOption("a", "aeron", false, "Indicates wither or not to generate the source using Aeron or not");
        options.addOption("s", "server", false, "Indicates wither Laser Raptor is generating client or server code");
        options.addOption("o", "output", true, "Generator source output location");
        options.addOption("g", "guice", false, "Indicates wither or not to generate Google Guice code - only valid with a JVM language");
        options.addOption("h", "help", false, "Prints this help message");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h")) {
            help(options);
            System.exit(-1);
        } else if (!cmd.hasOption("i")) {
            System.out.println("You must specify an input file");
            help(options);
            System.exit(-1);
        } else if (!cmd.hasOption("o")) {
            System.out.println("You must specify an output location");
            help(options);
            System.exit(-1);
        }

        // TODO remove when support is added....
        if (cmd.hasOption("a")) {
            System.out.println("Ignoring - aeron not supported yet");
        }

        if (cmd.hasOption("l")) {
            System.out.println("Ignoring - only java supported right now");
        }

        String input = cmd.getOptionValue("i");
        String output = cmd.getOptionValue("o");
        boolean server = cmd.hasOption("s");
        boolean guice = cmd.hasOption("g");

        LaserRaptor laserRaptor = new LaserRaptor(input, output, server);
        laserRaptor.generate();
    }

    private static void help(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("LaserRaptor -i <input file> -o <output location>", options);
    }

    public void generate() throws Exception {
        ANTLRFileStream fileStream = new ANTLRFileStream(input);
        LaserRaptorLexer lexer = new LaserRaptorLexer(fileStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();

        LaserRaptorListener laserRaptorListener = new LaserRaptorListener(guice);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(laserRaptorListener, laserRaptorContext);

        Map<String, MessageTemplate> messageTemplates = laserRaptorListener.getMessageTemplates();
        Map<String, ClientServiceTemplate> clientServiceTemplates = laserRaptorListener.getClientServiceTemplates();
        Map<String, ServerServiceTemplate> serverServiceTemplates = laserRaptorListener.getServerServiceTemplates();

        File outputDirectory = new File(output);
        outputDirectory.mkdirs();

        if (!outputDirectory.exists()) {
            throw new IllegalStateException("No directory found named " + output);
        }

        for (MessageTemplate messageTemplate : messageTemplates.values()) {
            String packageName = messageTemplate.getPackageName();
            packageName = packageName.replace(".", File.separator);
            File packageDir = new File(outputDirectory, packageName);
            packageDir.mkdirs();
            String className = messageTemplate.getClassName() + ".java";
            System.out.printf("Creating class named %s, in package %s\n", className, packageName);
            String render = messageTemplate.render();
            System.out.printf("Writing contents [%s]\n", render);
            File classFile = new File(packageDir, className);
            classFile.createNewFile();
            FileWriter writer = new FileWriter(classFile);
            writer.append(render);
            writer.flush();
            writer.close();
        }

        if (!server) {
            System.out.println("Generating client code");
            for (ClientServiceTemplate clientServiceTemplate : clientServiceTemplates.values()) {
                String packageName = clientServiceTemplate.getPackageName();
                packageName = packageName.replace(".", File.separator);
                File packageDir = new File(outputDirectory, packageName);
                packageDir.mkdirs();
                String className = clientServiceTemplate.getClassName() + ".java";
                System.out.printf("Creating class named %s, in package %s\n", className, packageName);
                String render = clientServiceTemplate.render();
                System.out.printf("Writing contents [%s]\n", render);
                File classFile = new File(packageDir, className);
                classFile.createNewFile();
                FileWriter writer = new FileWriter(classFile);
                writer.append(render);
                writer.flush();
                writer.close();
            }
        } else  {
            System.out.println("Generating server code");
            for (ServerServiceTemplate template : serverServiceTemplates.values()) {
                final String packageName = template.getPackageName().replace(".", File.separator);
                File packageDir = new File(outputDirectory, packageName);
                packageDir.mkdirs();


                for (ServerServiceTemplate.RenderedService renderedService : template.render()) {
                    String className = renderedService.getClassName() + ".java";
                    System.out.printf("Creating class named %s, in package %s\n", className, packageName);
                    String source = renderedService.getSource();

                    File classFile = new File(packageDir, className);

                    if (classFile.exists()) {
                        System.out.printf("Writing contents [%s]\n", source);
                        classFile.createNewFile();
                        FileWriter writer = new FileWriter(classFile);
                        writer.append(source);
                        writer.flush();
                        writer.close();
                    } else {
                        System.out.println("The class file " + classFile.getName() + " already exists - skipping file");
                    }
                }
            }

            if (guice) {
                GuiceModuleTemplate template = laserRaptorListener.getGuiceModuleTemplate();
                System.out.println("Generating guice server config");
                final String packageName = template.getPackageName().replace(".", File.separator);
                File packageDir = new File(outputDirectory, packageName);
                packageDir.mkdirs();

                String className = template.getClassName() + ".java";
                System.out.printf("Creating class named %s, in package %s\n", className, packageName);
                String source = template.render();

                File classFile = new File(packageDir, className);
                System.out.printf("Writing contents [%s]\n", source);
                classFile.createNewFile();
                FileWriter writer = new FileWriter(classFile);
                writer.append(source);
                writer.flush();
                writer.close();
            }
        }
    }
}
