package atrs;


import lombok.Data;
import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.DecisionService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableProcessApplication
public class Application {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    public void processPostDeploy(PostDeployEvent event) {

        ATRSTransaction t = new ATRSTransaction();
        t.id = "id_1";
        t.market = "xx";
        t.dttRate = 1;

//        ObjectValue objectValue = Variables.objectValue(t).serializationDataFormat(Variables.SerializationDataFormats.JSON)
//                .create();

        Map<String, Object> m = new HashMap<>();
        m.put("trx", t);

        runtimeService.startProcessInstanceByKey("trxValidationProcess", m);
    }


    @Data
    public static class ATRSTransaction {
        private String id;
        private String market;
        private Integer dttRate;
    }
}
