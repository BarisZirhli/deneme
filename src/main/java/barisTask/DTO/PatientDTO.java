package barisTask.DTO;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientDTO {

    public PatientDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Size(min = 3, max = 25, message = "min 3 characters max 25 characters should be ")
    @NotEmpty(message = "not okay email name ")
    private String name;
    @NotNull(message="not okay")
    @Email(regexp = "^(.+)@(.+)$", message = "not okay email")
    private String email;
    @NotNull(message="not okay")
    private String password;

    @NotNull(message="not okay")
    @AssertTrue
    public boolean isPasswordsEqual() {
        return (password.equalsIgnoreCase(null) || repeatPassword.equalsIgnoreCase(null)) ? false : password.equals(repeatPassword);
    }
    private String repeatPassword;

}
