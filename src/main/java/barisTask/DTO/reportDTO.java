package barisTask.DTO;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class reportDTO {

    private String id;
    private Date date;
    private String description;

}
