public class TopManager implements Employee {
    private StaffType staffType;
    private double fixedSalary;
    private double monthSalary;
    private Company company;
    final double BONUS = 150;
    final double SALARY_MIN = 100000.0;
    final double SALARY_MAX = 200000.0;
   //int employeeId = 0;


    public TopManager() {
        this.staffType = StaffType.TOP_MANAGER;
        fixedSalary = 0.0;
    }

    /*public void setId(int id) {
        this.employeeId = id;
    }
    public int getId() {
        return employeeId;
    }*/

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

    @Override
    public void setCompany(Company company) {
        this.company = company;
        if (!(company == null)) {
            fixedSalary = (SALARY_MIN + (Math.random() * (SALARY_MAX - SALARY_MIN)));
            if (company.getIncome() > 10000000) {
                monthSalary = fixedSalary + (fixedSalary * BONUS) / 100;
            } else {
                monthSalary = fixedSalary;
            }
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
        } if (getMonthSalary() < employee.getMonthSalary()) {
            return -1;
        }
        return 0;
    }
}
