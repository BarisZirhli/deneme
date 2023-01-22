package barisTask.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Report")
public class Report {

     @Id
@GenericGenerator(name = "uuid2", strategy = "uuid2")
@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
@Column(length = 36, nullable = false, updatable = false)
    private String id;
    private String name;
    private String LastName;
    private String patientId;
    private String diseaseDefination;
    @Temporal(TemporalType.DATE)
    private Date Date;
    private byte[] imageData;

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

}
