package franxx.code.validation.constraints;

import franxx.code.validation.enums.CaseMode;
import franxx.code.validation.groups.CreditCard;
import franxx.code.validation.groups.VirtualAccount;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@CheckCase(groups = {CreditCard.class, VirtualAccount.class},
        mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {CreditCard.class, VirtualAccount.class}, message = "{order.id.notblank}")
@Size(groups = {
        VirtualAccount.class,
        CreditCard.class
}, min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({FIELD})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {

    String message() default "invalid order id";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
