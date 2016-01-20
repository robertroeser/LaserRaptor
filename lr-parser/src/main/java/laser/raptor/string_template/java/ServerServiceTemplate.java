package laser.raptor.string_template.java;

import laser.raptor.core.InteractionModel;
import laser.raptor.core.MetadataFlyweight;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static laser.raptor.string_template.Util.uncapitalize;

public class ServerServiceTemplate extends JavaTemplate {

    final List<ServerServiceModel> serverServiceModels;

    STGroup serverServiceGroup;

    protected ServerServiceTemplate() {
        this(false);
    }

    protected ServerServiceTemplate(boolean guice) {
        super();

        serverServiceModels = new ArrayList<>();

        stGroupDir.load();

        String fileName = guice
            ?  "templates/java/LaserRaptorServerFunctionWithGuice.stg"
            :  "templates/java/LaserRaptorServerFunction.stg";

        serverServiceGroup = new STGroupFile(fileName);

    }

    public ServerServiceTemplate addServerService(ServerServiceModel serverServiceModel) {
        this.serverServiceModels.add(serverServiceModel);
        return this;
    }

    public static ServerServiceTemplate newServerServiceTemplate(boolean useGuice) {
        return new ServerServiceTemplate(useGuice);
    }


    public static ServerServiceTemplate newServerServiceTemplate() {
        return newServerServiceTemplate(false);
    }

    protected String renderFunction(ServerServiceModel serverServiceModel) {
        ST template = serverServiceGroup
            .getInstanceOf(serverServiceModel.getInteractionModel().getInteractionModelTemplateName());

        template.add("service_name", serverServiceModel.getServiceName());
        template.add("hash", serverServiceModel.getHash());
        template.add("method_id", serverServiceModel.getMethodId());
        template.add("request_type", serverServiceModel.getRequestType());

        if (!serverServiceModel.getInteractionModel().equals(InteractionModel.FIRE_AND_FORGET)) {
            template.add("response_type", serverServiceModel.getResponseType());
        }


        template.add("class_name", serverServiceModel.getMethodName());
        template.add("service_id", serverServiceModel.getServiceId());
        template.add("request_type_name", uncapitalize(serverServiceModel.getRequestType()) + "Observable");

        return  template.render();
    }

    protected String renderClass(String classBody) {
        ST service = serverServiceGroup.getInstanceOf("service");

        service.add("generated_date", generatedDate);
        service.add("laser_raptor_version", laserRaptorVersion);
        service.add("package_name", packageName);
        service.add("class_name", className);
        service.add("class_body", classBody);

        return service.render();
    }

    public List<RenderedService> render() {
        return serverServiceModels
            .stream()
            .map(model -> {
                String function = renderFunction(model);
                String body = renderClass(function);

                return new RenderedService(model.getServiceName() + "_" + model.getMethodName(), body);
            })
            .collect(Collectors.toList());
    }

    public List<ServerServiceModel> getServerServiceModels() {
        return serverServiceModels;
    }

    public static class RenderedService {
        String className;
        String source;

        public RenderedService(String className, String source) {
            this.className = className;
            this.source = source;
        }

        public String getClassName() {
            return className;
        }

        public String getSource() {
            return source;
        }
    }

    public static class ServerServiceModel {
        InteractionModel interactionModel;
        String serviceName;
        String requestType;
        String responseType;
        String methodName;
        int serviceId;
        int methodId;
        long hash;

        public ServerServiceModel(InteractionModel interactionModel, String serviceName, String requestType, String responseType, String methodName, int serviceId, int methodId) {
            this.interactionModel = interactionModel;
            this.serviceName = serviceName;
            this.requestType = requestType;
            this.responseType = responseType;
            this.methodName = methodName;
            this.serviceId = serviceId;
            this.methodId = methodId;

            MetadataFlyweight metadataFlyweight = new MetadataFlyweight();
            metadataFlyweight.setMethodId(methodId);
            metadataFlyweight.setServiceId(serviceId);
            this.hash = metadataFlyweight.getServiceMethodHash();
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

        public long getHash() {
            return hash;
        }

        public String getServiceName() {
            return serviceName;
        }
    }
}
