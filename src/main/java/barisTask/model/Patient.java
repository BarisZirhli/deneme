package barisTask.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient implements Serializable{

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patients")
    private List<Report> reports;
}
