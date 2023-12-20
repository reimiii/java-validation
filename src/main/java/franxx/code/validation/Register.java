package franxx.code.validation;

import franxx.code.validation.constraints.CheckPassword;
import jakarta.validation.constraints.NotBlank;

@CheckPassword(message = "password and retype must same..")
public class Register {

    @NotBlank(message = "username cannot blank")
    private String username;

    @NotBlank(message = "password cannot blank")
    private String password;

    @NotBlank(message = "retype password cannot blank")
    private String reTypePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reTypePassword='" + reTypePassword + '\'' +
                '}';
    }
}
