package atrs;

import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Map;

public class ValidationListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        DmnDecisionResult decisionResult = (DmnDecisionResult) execution.getVariable("decisionResult");
        System.err.println(decisionResult);
    }
}
