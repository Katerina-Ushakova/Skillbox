import java.util.HashSet;
import java.util.Set;

public interface Employee {
    //double fixedSalary = 100000;

    final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final java.util.Random rand = new java.util.Random();
    final Set<String> identifiers = new HashSet<>();

    String getName();
    void setCompany(Company company);
    double getMonthSalary();
    int compareTo(Employee employee);
}
