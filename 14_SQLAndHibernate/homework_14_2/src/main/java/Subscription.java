import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Data
public class Subscription {

    @EmbeddedId
    private Key id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;



}
