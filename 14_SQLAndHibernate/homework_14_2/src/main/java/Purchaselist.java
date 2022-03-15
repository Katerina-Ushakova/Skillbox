import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Purchaselist")
@Getter
@Setter
public class Purchaselist {

    @EmbeddedId
    private Key id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_name", referencedColumnName="name")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name", referencedColumnName="name")
    private Course course;


    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


}
