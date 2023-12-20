package franxx.code.validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidationTest {


    @Test
    void levelClass() {
        Register register = new Register();
        register.setUsername("");
        register.setPassword("rahasia");
        register.setReTypePassword("ga");

        validate(register);
    }
}
