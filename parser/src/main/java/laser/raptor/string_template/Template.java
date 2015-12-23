package laser.raptor.string_template;

import org.stringtemplate.v4.STGroupDir;

import java.util.Date;

public abstract class Template {
    protected Date generatedDate;
    protected String laserRaptorVersion;
    protected STGroupDir stGroupDir;

    protected Template(String groupDirector) {
        this.generatedDate = new Date();
        this.laserRaptorVersion = "1.0.0";
        this.stGroupDir = new STGroupDir(groupDirector);
        stGroupDir.verbose = true;
    }
}