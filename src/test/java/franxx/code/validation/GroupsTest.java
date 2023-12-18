package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import franxx.code.validation.groups.VirtualAccount;
import org.junit.jupiter.api.Test;

public class GroupsTest extends AbstractValidationTest {
    @Test
    void creditCard() {
        Payment payment = new Payment();
        payment.setOrderId("000111");
        payment.setCreditCard("44141411");
        payment.setAmount(10000L);
        validateWithGroups(payment, CreditCard.class);
    }

    @Test
    void virtualAccount() {

        Payment payment = new Payment();
        payment.setOrderId("000111");
        payment.setVirtualAccount(" ");
        payment.setAmount(10000L);
        validateWithGroups(payment, VirtualAccount.class);
    }
}
