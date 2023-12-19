package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import franxx.code.validation.groups.VirtualAccount;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInternationalizationTest extends AbstractValidationTest {

    @Test
    void i18n() {
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();

        payment.setOrderId("1010101001101010101010101");
        payment.setAmount(10L);

        validateWithGroups(payment, VirtualAccount.class);
    }

    @Test
    void messageInterpolator() {
        Locale locale = new Locale("in", "ID");

        Payment payment = new Payment();

        payment.setOrderId("1010101001101010101010101");
        payment.setAmount(10L);

        Set<ConstraintViolation<Object>> validate = validator.validate(payment, CreditCard.class);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context messageInterpolatorContext = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(), ExpressionLanguageFeatureLevel.VARIABLES,
                    true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), messageInterpolatorContext, locale);
            System.out.println(message);

            System.out.println("+++++++++++++++++++++++++");
        }
    }
}
