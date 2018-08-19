package atrs;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Map;

public class TransactionValidator implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.err.println("--> TransactionValidator");

        System.err.println(delegateExecution);
        System.err.println("validate transaction...");

        Map<String, Object> variables = delegateExecution.getVariables();
        System.err.println(String.valueOf(variables));


        delegateExecution.setVariable("transaction_status", "valid");

        System.err.println("<-- TransactionValidator");
    }
}
