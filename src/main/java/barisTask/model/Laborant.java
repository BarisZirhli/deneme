package barisTask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "labinfo")
public class Laborant {

  @Id
@GenericGenerator(name = "uuid2", strategy = "uuid2")
@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
@Column(length = 36, nullable = false, updatable = false)
    private String id;
    private String navme;
    private String lavstName;
    private String laborantId;

}
