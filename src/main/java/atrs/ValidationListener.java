package atrs;

import atrs.model.AtrsTransaction;
import atrs.model.TrxValidationResult;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

import java.util.List;
import java.util.Map;

public class ValidationListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        AtrsTransaction trx = (AtrsTransaction) execution.getVariable("trx");
        System.err.println("trx: " + trx);

        Map<String, Object> result = (Map<String,Object>)execution.getVariable("result");
        System.err.println("res: " + result);

        List<TrxValidationResult> trxValidationResults = (List<TrxValidationResult>) execution.getVariable("trxValidationResults");
        System.err.println(trxValidationResults);

        TrxValidationResult trxValidationResult = TrxValidationResult.builder()
                .trxId(trx.getId())
                .valid(Boolean.valueOf(String.valueOf(result.get("valid"))))
                .reason(String.valueOf(result.get("reason")))
                .build();


        trxValidationResults.add(trxValidationResult);
    }
}
