package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidationTest {

    @Test
    void composition() {
        Payment payment = new Payment();
        payment.setOrderId("ajoajwoaowjaojwoajowjaojwoajowaow");

        validateWithGroups(payment, CreditCard.class);
    }
}
