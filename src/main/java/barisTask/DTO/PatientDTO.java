package barisTask.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDTO {

    private String name;
    private String email;
    private String password;
    private String repeatPassword;

}
