package franxx.code.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidationTest {

    protected ValidatorFactory factory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = factory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        factory.close();
    }

    void validate(Object object) {
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("+++++++++++++++++++++++++");
        }
    }
    void validateWithGroups(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> validate = validator.validate(object, groups);
        for (ConstraintViolation<Object> violation : validate) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("+++++++++++++++++++++++++");
        }
    }
}
