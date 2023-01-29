package barisTask.DTO;

import javax.validation.constraints.AssertTrue;
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
    @NotEmpty(message = "Not Empty")
    private String name;
    @NotEmpty
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;

    @AssertTrue(message = "Passwords should have been match")
    public boolean isPasswordsEqual() {
        return (password == null) ? false : password.equals(repeatPassword);
    }
}
