package barisTask.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "patients")
@Setter
@Getter
@NoArgsConstructor
public class Patient {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")

    private String id;
    private String name;
    private String email;
    private String password;

    public Patient(String name, String email, String password) {

        this.name = name;
        this.email = email;
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    /* @JoinTable(name = "reports",
            joinColumns = @JoinColumn(name = "patients_id"),
            inverseJoinColumns = @JoinColumn(name = "reports_id"))*/
    private HashSet<Report> report;
}
