package franxx.code.validation.service;

import franxx.code.validation.constraints.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1,
            reTypePasswordParam = 2
    )
    public void register(@NotBlank(message = "username cannot blank") String username,
                         @NotBlank(message = "password cannot blank") String password,
                         @NotBlank(message = "retype password cannot blank") String reTypePassword) {

        // TODO Register
    }

}
