import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class Key implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

}
