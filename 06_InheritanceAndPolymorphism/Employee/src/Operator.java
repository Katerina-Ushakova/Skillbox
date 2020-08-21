import java.awt.font.TextHitInfo;
import java.util.HashSet;
import java.util.Set;

public class Operator implements Employee {
    private StaffType staffType;
    private double fixedSalary;
    private double monthSalary;
    private Company company;
    final double SALARY_MIN = 100000.0;
    final double SALARY_MAX = 200000.0;

    //int employeeId = 0;


    public Operator() {
        this.staffType = StaffType.OPERATOR;
        fixedSalary = 0.0;

    }
    @Override
    public String getName() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(letters.charAt(rand.nextInt(letters.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }



    /*public void setId(int id) {
        this.employeeId = id;
    }

    public int getId() {
        return employeeId;
    }*/

    @Override
    public void setCompany(Company company) {
        this.company = company;
        if (!(company == null)) {
            fixedSalary = (SALARY_MIN + (Math.random() * (SALARY_MAX - SALARY_MIN)));
            monthSalary = fixedSalary;
        } else {
            monthSalary = 0.0;
        }
    }

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public int compareTo(Employee employee) {
        if (getMonthSalary() > employee.getMonthSalary()) {
            return 1;
        }
        if (getMonthSalary() < employee.getMonthSalary()) {
            return -1;
        }
        return 0;
    }
}
