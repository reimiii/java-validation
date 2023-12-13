package franxx.code.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstrainViolationTest {
    private ValidatorFactory factory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void validationFailedBlank() {
        Person person = new Person();
        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        assertEquals(2, validate.size());

        for (ConstraintViolation<Person> violation : validate) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Annotation: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid: " + violation.getInvalidValue());
            System.out.println();
            violation.getPropertyPath().forEach(node -> {
                System.out.println(node.getName());
            });
        }
    }

    @Test
    void validationFailedSize() {
        Person person = new Person();
        person.setFirstName("iqjwoiejoqjweoqijweoiqwjeoiqjoqiejqoiwejqiojweqo");
        person.setLastName("iqjwoiejoqjweoqijweoiqwjeoiqjoqiejqoiwejqiojweqo");
        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        assertEquals(2, validate.size());

        for (ConstraintViolation<Person> violation : validate) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Annotation: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid: " + violation.getInvalidValue());
            System.out.println();
            violation.getPropertyPath().forEach(node -> {
                System.out.println(node.getName());
            });
        }
    }

    @Test
    void validationSuccess() {
        Person person = new Person();
        person.setFirstName("Hilmi");
        person.setLastName("AM");

        Set<ConstraintViolation<Person>> validate = validator.validate(person);

        assertEquals(0, validate.size());
    }

    @AfterEach
    void tearDown() {
        factory.close();
    }
}
