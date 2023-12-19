package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidationTest {


    @Test
    void groups() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(10000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        validateWithGroups(payment, CreditCard.class);
    }

}
