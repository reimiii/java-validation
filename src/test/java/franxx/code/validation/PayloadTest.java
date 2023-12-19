package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import franxx.code.validation.payloads.EmailError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends AbstractValidationTest {

    @Test
    void payload() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(10000L);
        payment.setCreditCard("111111111111111");


        Set<ConstraintViolation<Object>> validate = validator.validate(payment, CreditCard.class);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> aClass : payload) {
                if (aClass == EmailError.class) {
                    EmailError emailError = new EmailError();
                    emailError.sendEmail(violation);
                }
            }

            System.out.println("+++++++++++++++++++++++++");
        }


    }
}
