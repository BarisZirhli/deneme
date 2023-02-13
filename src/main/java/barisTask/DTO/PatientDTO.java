package barisTask.DTO;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO {

    public PatientDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Size(min = 10, max = 25, message = "min 10 characters max 25 characters should be ")
    @NotEmpty(message = "not okay name")
    private String name;
    
    @NotEmpty(message = "not okay")
    @Email(regexp = "^(.+)@(.+)$", message = "not okay email")
    private String email;
    
    @NotEmpty(message = "not okay password")
    @Size(min = 6, max = 25,message = "min 6 characters max 25 characters should be")
    private String password;

    @NotEmpty(message = "not okay")
    private String repeatPassword;
    /*
    @AssertTrue
    public boolean isPasswordsEqual() {
        return (password.equalsIgnoreCase(null) || repeatPassword.equalsIgnoreCase(null))
                ? false : password.equals(repeatPassword);
    }
    */

}
