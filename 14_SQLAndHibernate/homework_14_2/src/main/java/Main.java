import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Query<LinkedPurchaseList> query = session.createQuery("From LinkedPurchaseList");
        List<LinkedPurchaseList> linkedPurchaseLists = query.list();
        linkedPurchaseLists.forEach(LinkedPurchaseList::toString);
        System.out.println("Таблица готова");

        sessionFactory.close();
    }


    /*Course course = session.get(Course.class, 1);
        System.out.println("На курсе '" + course.getName() + "' обучается " + course.getStudentsCount() + " студентов:)");
        System.out.println("Учитель : " +course.getTeacher().getName());
        System.out.println("Студентов : " + course.getStudents().size());
        List<Student> studentList = course.getStudents();
        for (Student student : studentList)
            System.out.println(student.getName());*/

        /*CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root)
                .where(builder.greaterThan(root.get("price"), 100000))
                .orderBy(builder.desc(root.get("price")));
        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();
        for (Course course : courseList)
            System.out.println(course.getName() + " - " + course.getPrice());*/

        /*String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
        List<Course> courseList = session.createQuery(hql).getResultList();
        for (Course course : courseList)
            System.out.println(course.getName() + " - " + course.getPrice());*/
}
