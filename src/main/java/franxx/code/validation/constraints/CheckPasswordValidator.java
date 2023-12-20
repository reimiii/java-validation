package franxx.code.validation.constraints;

import franxx.code.validation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        this.messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if ((value.getPassword() == null) || (value.getReTypePassword() == null) || (value.getUsername() == null)) {
            return true; // skip validation
        }

        boolean isValid = value.getPassword().equals(value.getReTypePassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();


            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("reTypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
