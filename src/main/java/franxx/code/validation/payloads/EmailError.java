package franxx.code.validation.payloads;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailError implements Payload {

    public void sendEmail(ConstraintViolation<?> violation) {
        System.out.println("Send email: " + violation.getMessage());
    }

}
