package franxx.code.validation;

import org.junit.jupiter.api.Test;

public class HibernateValidatorConstrainTest extends AbstractValidationTest {

    @Test
    void invalid() {
        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("0001");
        payment.setCreditCard("333");

        validate(payment);
    }

    @Test
    void valid() {
        Payment payment = new Payment();
        payment.setAmount(10_000L);
        payment.setOrderId("0002");
        payment.setCreditCard("1123450987612345");

        validate(payment);
    }
}
