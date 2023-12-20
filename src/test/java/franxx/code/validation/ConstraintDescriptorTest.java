package franxx.code.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidationTest {

    @Test
    void descriptor() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        for (ConstraintViolation<Person> violation : validate) {
            ConstraintDescriptor<?> constraintDescriptor = violation.getConstraintDescriptor();

            System.out.println(constraintDescriptor.getAnnotation());
            System.out.println(constraintDescriptor.getAttributes());
            System.out.println(constraintDescriptor.getPayload());
            System.out.println(constraintDescriptor.getGroups());
            System.out.println(constraintDescriptor.getMessageTemplate());
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
        }
    }
}
