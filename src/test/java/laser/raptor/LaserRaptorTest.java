package laser.raptor;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
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

        File packageDir = new File(outputDir, "laser/raptor/test");

        File[] files = packageDir.listFiles((File dir, String name) -> {
           return name.endsWith(".java");
        });

        assertEquals(4, files.length);

    }
}