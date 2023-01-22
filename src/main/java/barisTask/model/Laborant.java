package barisTask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Labinfo")
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ivd;
    private String navme;
    private String lavstName;
    private String laborantId;

}
