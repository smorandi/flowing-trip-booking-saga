package atrs;

import atrs.model.TrxValidationResult;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.List;
import java.util.Map;

public class DatabaseUpdater implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.err.println("--> DatabaseUpdater");


        List<TrxValidationResult> trxValidationResults = (List<TrxValidationResult>) execution.getVariable("trxValidationResults");
        System.err.println(trxValidationResults);

        System.err.println("<-- DatabaseUpdater");
    }
}
