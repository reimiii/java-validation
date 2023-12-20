package franxx.code.validation;

import franxx.code.validation.extractor.DataIntegerValueExtractor;
import franxx.code.validation.extractor.DataValueExtractor;
import franxx.code.validation.extractor.EntryValueExtractorKey;
import franxx.code.validation.extractor.EntryValueExtractorValue;
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
//        factory = Validation.buildDefaultValidatorFactory();
        factory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
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
