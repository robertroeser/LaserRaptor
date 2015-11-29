package laser.raptor;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static org.junit.Assert.assertTrue;


public class LaserRaptorTest {
    @Test
    public void testGenerateSimpleMessage() throws Exception {

        URL systemResource =
                ClassLoader.getSystemResource("simpleMessage.lr");

        File outputDir = new File("/tmp", "testGenerateSimpleMessage");

        if (outputDir.exists()) {
            Runtime.getRuntime().exec("rm -fr " + outputDir.getPath());
        }

        outputDir.mkdirs();

        LaserRaptor laserRaptor = new LaserRaptor(systemResource.getFile(), outputDir.getPath());
        laserRaptor.generate();

        assertTrue(outputDir.exists());

        File packageDir = new File(outputDir, "laser/raptor/test");

        assertTrue(packageDir.exists());

        File testMessage = new File(packageDir, "TestMessageRequest.java");

        assertTrue(testMessage.exists());

        byte[] bytes = Files.readAllBytes(testMessage.toPath());
        assertTrue("", bytes.length != 0);

        String rendered = new String(bytes);

        assertTrue(rendered.contains("TestMessageRequest"));
    }

    @Test
    public void testGenerateEmebbedMessage() throws Exception {
        URL systemResource =
                ClassLoader.getSystemResource("embeddedMessage.lr");

        File outputDir = new File("/tmp", "testGenerateEmebbedMessage");

        if (outputDir.exists()) {
            Runtime.getRuntime().exec("rm -fr " + outputDir.getPath());
        }

        outputDir.mkdirs();

        LaserRaptor laserRaptor = new LaserRaptor(systemResource.getFile(), outputDir.getPath());
        laserRaptor.generate();

        boolean found = true;

        File packageDir = new File(outputDir, "laser/raptor/test");

        for (int i = 0; i < 4; i++) {
            final int j = i;
            found &=
                    Files
                            .find(
                                    packageDir
                                            .toPath(), 1, (Path p, BasicFileAttributes b) -> ("E" + j) == p.toFile().getName()
                            )
                            .findFirst()
                            .isPresent();
        }

    }
}