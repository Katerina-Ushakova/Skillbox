import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    @EmbeddedId
    private Key id;

    public LinkedPurchaseList(int courseId, int studentId) {
        this.id = new Key(courseId, studentId);
    }

    @Data
    @Embeddable
    public static class Key implements Serializable {

        @Column(name = "course_id")
        int courseId;

        @Column(name = "student_id")
        int studentId;

        public Key(int courseId, int studentId) {
            this.courseId = courseId;
            this.studentId = studentId;
        }

        @Override
        public String toString() {
            return "Course Id = " + courseId + "\t\tStudent Id = " + studentId;
        }
    }
}
