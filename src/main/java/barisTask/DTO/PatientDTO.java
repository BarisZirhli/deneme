package barisTask.DTO;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    
    @NotBlank(message = "not okay")
    @Email(regexp = "^(.+)@(.+)$", message = "not okay email")
    private String email;
    
    @NotEmpty(message = "not okay password")
    @Size(min = 6, max = 25)
    private String password;
    

    @NotEmpty(message = "not okay")
    @NotNull
    @AssertTrue
    public boolean isPasswordsEqual() {
        return (password.equalsIgnoreCase(null) || repeatPassword.equalsIgnoreCase(null))
                ? false : password.equals(repeatPassword);
    }
    private String repeatPassword;

}
