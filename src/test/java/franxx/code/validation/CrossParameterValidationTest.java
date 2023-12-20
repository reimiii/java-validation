package franxx.code.validation;

import franxx.code.validation.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidationTest {

    @Test
    void crossParam() throws NoSuchMethodException {
        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);
        String username = "MEE";
        String password = "mm";
        String retypePassword = "mm";

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, method, new Object[]{
                        username, password, retypePassword
                });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===========");
        }
    }
}
