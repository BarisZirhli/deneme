package barisTask.DTO;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReportDTO {

    private String id;
    private Date date;
    private String description;

}
