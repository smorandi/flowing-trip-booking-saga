package atrs;

import atrs.model.AtrsTransaction;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionCollector implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.err.println("--> TransactionCollector");

        List<AtrsTransaction> transactions = Stream.of(
                AtrsTransaction.builder().id("1").dttRate(111).market("CH").build(),
                AtrsTransaction.builder().id("2").dttRate(222).market("DE").build(),
                AtrsTransaction.builder().id("3").dttRate(333).market("FR").build()
        ).collect(Collectors.toList());

        delegateExecution.setVariable("transactions", transactions);
        delegateExecution.setVariable("trxValidationResults", new ArrayList<>());

        System.err.println("<-- TransactionCollector");
    }
}
