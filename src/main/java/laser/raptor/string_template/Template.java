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

/*
class StringTemplateServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();
    ServletContext context = getServletContext();
    String templatePath = context.getRealPath("/WEB-INF");
    StringTemplateGroup group = new StringTemplateGroup("underwebinf", templatePath);
    // removes the leading "/" and the trailing ".st"
    String servletPath = request.getServletPath().substring(1,request.getServletPath().lastIndexOf(".st"));
    StringTemplate page = group.getInstanceOf(servletPath);
    out.print(page);
 */