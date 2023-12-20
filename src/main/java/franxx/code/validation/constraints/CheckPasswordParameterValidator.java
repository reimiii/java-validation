package franxx.code.validation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {

    private int passwordParam;

    private int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        this.passwordParam = constraintAnnotation.passwordParam();
        this.retypePasswordParam = constraintAnnotation.reTypePasswordParam();
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {

        String password = (String) value[passwordParam];
        String retype = (String) value[retypePasswordParam];

        if (password == null || retype == null) {
            return true;
        }

        return password.equals(retype);
    }
}
