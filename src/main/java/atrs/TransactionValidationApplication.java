package atrs;


import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableProcessApplication
public class TransactionValidationApplication {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(String... args) throws Exception {
        SpringApplication.run(TransactionValidationApplication.class, args);
    }

    @EventListener
    public void processPostDeploy(PostDeployEvent event) {


//        ProcessInstantiationBuilder transactionValidationProcess = runtimeService.createProcessInstanceByKey("trxValidationProcess");
//        ProcessInstance processInstance = transactionValidationProcess.execute();

        runtimeService.startProcessInstanceByKey("trxValidationProcess");
    }
}
