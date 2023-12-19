package franxx.code.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidationTest {

    @Test
    void sayHello() throws NoSuchMethodException {
        Person person = new Person();
        String name = "Himmmilll";

        Method method = Person.class.getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator
                .validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : constraintViolations) {

            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("++++++++++++++++++++");

        }

    }

    @Test
    void fullName() throws NoSuchMethodException {

        Person person = new Person();
        person.setFirstName("Huuhh");
        person.setLastName("");

        String returnValue = person.fullName();

        Method method = Person.class.getMethod("fullName");

        Set<ConstraintViolation<Person>> constraintViolations = executableValidator.
                validateReturnValue(person, method, returnValue);

        for (ConstraintViolation<Person> violation : constraintViolations) {

            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("++++++++++++++++++++");

        }
    }
}