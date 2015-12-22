package laser.raptor.string_template.java;

import laser.raptor.core.InteractionModel;
import org.stringtemplate.v4.NoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static laser.raptor.string_template.Util.uncapitalize;

public class ClientServiceTemplate extends JavaTemplate {
    final List<MethodModel> methods;

    STGroup laserRaptorClientService;

    protected ClientServiceTemplate() {
        super();

        methods = new ArrayList<>();

        stGroupDir.load();
        String fileName  = stGroupDir.getFileName() + File.separator + "LaserRaptorClientService.stg";
        laserRaptorClientService = new STGroupFile(fileName);
    }

    public static ClientServiceTemplate newClientServiceTemplate() {
        return new ClientServiceTemplate();
    }

    public ClientServiceTemplate addMethod(MethodModel methodModel) {
        methods.add(methodModel);
        return  this;
    }

    protected String renderMethod(MethodModel methodModel) {
        ST methodTemplate =
                laserRaptorClientService
                        .getInstanceOf(methodModel
                                .getInteractionModel()
                                .getMethodTemplateName());

        methodTemplate.add("methodName", methodModel.getMethodName());
        methodTemplate.add("requestType", methodModel.getRequestType());
        methodTemplate.add("requestName", uncapitalize(methodModel.getRequestType()) + "Observable");

        if (!methodModel.getInteractionModel().equals(InteractionModel.FIRE_AND_FORGET)) {
            methodTemplate.add("responseType", methodModel.getResponseType());
        }

        methodTemplate.add("serviceId", methodModel.getServiceId());
        methodTemplate.add("methodId", methodModel.getMethodId());

        return methodTemplate.render();
    }

    protected String render() {
        ST client = laserRaptorClientService.getInstanceOf("client");

        client.add("generated_date", generatedDate);
        client.add("laser_raptor_version", laserRaptorVersion);
        client.add("package_name", packageName);
        client.add("class_name", className);

        StringBuilder sb = new StringBuilder();

        methods
                .stream()
                .map(this::renderMethod)
                .forEach(sb::append);

        client.add("methods", sb.toString());

        StringWriter stringWriter = new StringWriter();
        NoIndentWriter writer = new NoIndentWriter(stringWriter);
        try {
            client.write(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    public static class MethodModel {
        InteractionModel interactionModel;
        String requestType;
        String responseType;
        String methodName;
        int serviceId;
        int methodId;

        public MethodModel(InteractionModel interactionModel, String requestType, String responseType, String methodName, int serviceId, int methodId) {
            this.interactionModel = interactionModel;
            this.requestType = requestType;
            this.responseType = responseType;
            this.methodName = methodName;
            this.serviceId = serviceId;
            this.methodId = methodId;
        }

        public InteractionModel getInteractionModel() {
            return interactionModel;
        }

        public String getRequestType() {
            return requestType;
        }

        public String getResponseType() {
            return responseType;
        }

        public String getMethodName() {
            return methodName;
        }

        public int getServiceId() {
            return serviceId;
        }

        public int getMethodId() {
            return methodId;
        }
    }
}
