package franxx.code.validation.constraints;

import franxx.code.validation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {
    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if ((value.getPassword() == null) || (value.getReTypePassword() == null) || (value.getUsername() == null)) {
            return true; // skip validation
        }

        return value.getPassword().equals(value.getReTypePassword());
    }
}
