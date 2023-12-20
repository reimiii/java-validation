package franxx.code.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidationTest {


    @Test
    void container() {
        Person person = new Person();

        person.setFirstName("ME");
        person.setLastName("AA");
        person.setAddress(new Address());

        person.getAddress().setCity("Bogor");
        person.getAddress().setCountry("ID");
        person.getAddress().setStreet("HMMMSSZZ");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add(" ");
        person.getHobbies().add("Gaming");

        validate(person);
    }
}
