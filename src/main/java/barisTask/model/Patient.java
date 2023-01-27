package barisTask.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "patients")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Size(min = 3, max = 25,message = "min 3 characters max 25 characters should be ")
    @NotEmpty(message ="Not Empty")
    @SuppressWarnings("deprecation")
    private String id;
    private String name;
    private String lastName;
    @Email(message="Not Proper Email")
    @NotEmpty(message ="Not Empty")
    private String email;
    private String password;
    private String repeatPassword;

    @AssertTrue(message = "Passwords should have been match")
    public boolean isPasswordsEqual() {
        return (password == null) ? false : password.equals(repeatPassword);
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Report> report;
}
