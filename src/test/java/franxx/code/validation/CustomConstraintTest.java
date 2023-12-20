package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidationTest{

    @Test
    void testCustom() {
        Payment payment = new Payment();
        payment.setOrderId("MMEEE");

        validateWithGroups(payment, CreditCard.class);
    }
}
