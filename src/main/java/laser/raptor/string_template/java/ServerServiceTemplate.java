package laser.raptor.string_template.java;

import laser.raptor.core.InteractionModel;
import org.stringtemplate.v4.NoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import uk.co.real_logic.agrona.BitUtil;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import static laser.raptor.string_template.Util.uncapitalize;

public class ServerServiceTemplate extends JavaTemplate {

    final List<ServiceFunction> serviceFunctions;

    STGroup serverServiceGroup;

    protected ServerServiceTemplate() {
        super();

        serviceFunctions = new ArrayList<>();

        stGroupDir.load();
        String fileName = stGroupDir.getFileName() + File.separator + "LaserRaptorServerFunction.stg";
        serverServiceGroup = new STGroupFile(fileName);

    }

    public void addServiceFunction(ServiceFunction serviceFunction) {
        this.serviceFunctions.add(serviceFunction);
    }

    public static ServerServiceTemplate newServerServiceTemplate() {
        return new ServerServiceTemplate();
    }

    protected String renderFunction(ServiceFunction serviceFunction) {
        ST template = serverServiceGroup
            .getInstanceOf("function");

        template.add("hash", serviceFunction.getHash());
        template.add("method_id", serviceFunction.getMethodId());
        template.add("request_type", serviceFunction.getRequestType());

        if (!serviceFunction.getInteractionModel().equals(InteractionModel.FIRE_AND_FORGET)) {
            template.add("response_type", serviceFunction.getResponseType());
        } else {
            template.add("response_type", "Void");
        }


        template.add("class_name", serviceFunction.getMethodName());
        template.add("service_id", serviceFunction.getServiceId());
        template.add("request_type_name", uncapitalize(serviceFunction.getRequestType()) + "Observable");

        return  template.render();
    }

    protected String render() {
        ST service = serverServiceGroup.getInstanceOf("service");

        service.add("generated_date", generatedDate);
        service.add("laser_raptor_version", laserRaptorVersion);
        service.add("package_name", packageName);
        service.add("class_name", className);

        StringBuilder sb = new StringBuilder();

        serviceFunctions
            .stream()
            .map(this::renderFunction)
            .forEach(sb::append);

        StringWriter stringWriter = new StringWriter();
        NoIndentWriter writer = new NoIndentWriter(stringWriter);
        try {
            service.write(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    public class ServiceFunction {
        InteractionModel interactionModel;
        String requestType;
        String responseType;
        String methodName;
        int serviceId;
        int methodId;
        long hash;

        public ServiceFunction(InteractionModel interactionModel, String requestType, String responseType, String methodName, int serviceId, int methodId, long hash) {
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
