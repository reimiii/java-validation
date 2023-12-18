package franxx.code.validation;

import franxx.code.validation.groups.PaymentGroups;
import org.junit.jupiter.api.Test;

public class GroupsSequenceTest extends AbstractValidationTest {

    @Test
    void groups() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(10000L);
        payment.setCreditCard("4123450987612345");

        validateWithGroups(payment, PaymentGroups.class);
    }
}
