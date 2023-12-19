package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidationTest {

    @Test
    void message() {
        Payment payment = new Payment();
        payment.setOrderId("11111111111111111111111111111111");
        payment.setAmount(10L);
        payment.setCreditCard("");

        validateWithGroups(payment, CreditCard.class);
    }
}
