package laser.raptor.string_template.java;

import laser.raptor.core.InteractionModel;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import uk.co.real_logic.agrona.BitUtil;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static laser.raptor.string_template.Util.uncapitalize;

public class ServerServiceTemplate extends JavaTemplate {

    final List<ServerServiceModel> serverServiceModels;

    STGroup serverServiceGroup;

    protected ServerServiceTemplate() {
        super();

        serverServiceModels = new ArrayList<>();

        stGroupDir.load();
        String fileName = stGroupDir.getFileName() + File.separator + "LaserRaptorServerFunction.stg";
        serverServiceGroup = new STGroupFile(fileName);

    }

    public ServerServiceTemplate addServerService(ServerServiceModel serverServiceModel) {
        this.serverServiceModels.add(serverServiceModel);
        return this;
    }

    public static ServerServiceTemplate newServerServiceTemplate() {
        return new ServerServiceTemplate();
    }

    protected String renderFunction(ServerServiceModel serverServiceModel) {
        ST template = serverServiceGroup
            .getInstanceOf(serverServiceModel.getInteractionModel().getInteractionModelTemplateName());

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

    protected List<String> render() {
        return serverServiceModels
            .stream()
            .map(this::renderFunction)
            .map(this::renderClass)
            .collect(Collectors.toList());
    }

    public static class ServerServiceModel {
        InteractionModel interactionModel;
        String requestType;
        String responseType;
        String methodName;
        int serviceId;
        int methodId;
        long hash;

        public ServerServiceModel(InteractionModel interactionModel, String requestType, String responseType, String methodName, int serviceId, int methodId) {
            this.interactionModel = interactionModel;
            this.requestType = requestType;
            this.responseType = responseType;
            this.methodName = methodName;
            this.serviceId = serviceId;
            this.methodId = methodId;

            ByteBuffer byteBuffer = ByteBuffer.allocate(BitUtil.SIZE_OF_LONG);
            byteBuffer.putInt(0, serviceId);
            byteBuffer.putInt(BitUtil.SIZE_OF_INT, methodId);

            this.hash = byteBuffer.getLong(0);

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
    }
}
