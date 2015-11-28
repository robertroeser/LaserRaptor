package laser.raptor.string_template;

import java.util.HashSet;
import java.util.Set;

public class Util {
    private static final Set<String> RESERVED_WORDS = new HashSet<>();

    static {
        // Java 8
        RESERVED_WORDS.add("abstract");
        RESERVED_WORDS.add("continue");
        RESERVED_WORDS.add("for");
        RESERVED_WORDS.add("new");
        RESERVED_WORDS.add("switch");
        RESERVED_WORDS.add("assert");
        RESERVED_WORDS.add("default");
        RESERVED_WORDS.add("goto");
        RESERVED_WORDS.add("package");
        RESERVED_WORDS.add("synchronized");
        RESERVED_WORDS.add("boolean");
        RESERVED_WORDS.add("do");
        RESERVED_WORDS.add("if");
        RESERVED_WORDS.add("private");
        RESERVED_WORDS.add("this");
        RESERVED_WORDS.add("break");
        RESERVED_WORDS.add("double");
        RESERVED_WORDS.add("implements");
        RESERVED_WORDS.add("protected");
        RESERVED_WORDS.add("throw");
        RESERVED_WORDS.add("byte");
        RESERVED_WORDS.add("else");
        RESERVED_WORDS.add("import");
        RESERVED_WORDS.add("public");
        RESERVED_WORDS.add("throws");
        RESERVED_WORDS.add("case");
        RESERVED_WORDS.add("enum");
        RESERVED_WORDS.add("instanceof");
        RESERVED_WORDS.add("return");
        RESERVED_WORDS.add("transient");
        RESERVED_WORDS.add("catch");
        RESERVED_WORDS.add("extends");
        RESERVED_WORDS.add("int");
        RESERVED_WORDS.add("short");
        RESERVED_WORDS.add("try");
        RESERVED_WORDS.add("char");
        RESERVED_WORDS.add("final");
        RESERVED_WORDS.add("interface");
        RESERVED_WORDS.add("static");
        RESERVED_WORDS.add("void");
        RESERVED_WORDS.add("class");
        RESERVED_WORDS.add("finally");
        RESERVED_WORDS.add("long");
        RESERVED_WORDS.add("strictfp");
        RESERVED_WORDS.add("volatile");
        RESERVED_WORDS.add("const");
        RESERVED_WORDS.add("float");
        RESERVED_WORDS.add("native");
        RESERVED_WORDS.add("super");
        RESERVED_WORDS.add("while");

        // LasorRaptor
        RESERVED_WORDS.add("binary");
        RESERVED_WORDS.add("namespace");
        RESERVED_WORDS.add("message");
        RESERVED_WORDS.add("service");
        RESERVED_WORDS.add("request");
        RESERVED_WORDS.add("requestN");
        RESERVED_WORDS.add("subscribe");
        RESERVED_WORDS.add("channel");
        RESERVED_WORDS.add("fire");


    }

    public static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String uncapitalize(String input) {
        char[] chars = input.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    public static boolean reservedWord(String input) {
        return RESERVED_WORDS.contains(input);
    }

}
