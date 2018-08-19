package atrs;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.TypedValue;

import java.util.Map;

public class DatabaseUpdater implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.err.println("--> DatabaseUpdater");

        System.err.println(delegateExecution);

        Map<String, Object> variables = delegateExecution.getVariables();
        System.err.println(String.valueOf(variables));

        Application.ATRSTransaction trx = (Application.ATRSTransaction) delegateExecution.getVariable("trx");

        System.err.println("<-- DatabaseUpdater");
    }
}
