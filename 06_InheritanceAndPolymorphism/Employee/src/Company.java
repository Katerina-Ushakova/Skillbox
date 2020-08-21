import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    public int income;
    public List company = new ArrayList();
    public String name = " ";
    public void setIncome(int income) {
        this.income = income;
    }

    public int getIncome(){
        return income;
    }

    public Company(String name) {
    income = income;
    this.name = name;
    }

    public void hire(Employee employee) {
        company.add(employee);
        employee.setCompany(this);
    }


    public void hireAll(ArrayList<Employee> employeeList) {
        this.company.addAll(employeeList);
        for (Employee employee : employeeList){
            employee.setCompany(this);
        }
    }

    public void fire(Employee employee) {
        company.remove(employee);
    }


    public ArrayList<Employee> getTopSalaryStaff(int count) {
        company.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return -1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < count; i++) {
            //System.out.println(company.get(i).);
        }
        return company.subList(0,count);
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {

        return null;
    }

}
