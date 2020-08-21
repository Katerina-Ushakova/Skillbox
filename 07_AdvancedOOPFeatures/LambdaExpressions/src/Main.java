import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Calendar.*;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        Collections.sort(staff, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));

        Calendar starDate = Calendar.getInstance();
        starDate.set(2017,0,1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2017,12,31);

        Stream<Employee> stream = staff.stream();
        stream.filter(employee -> employee.getWorkStart().before(endDate.getTime())
                && employee.getWorkStart().after(starDate.getTime()))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        /*for(Employee employee : staff) {
            System.out.println(employee);
        }*/
        //staff.forEach(System.out::println);


        /* БОЛЕЕ ДЛИНННЫЙ ВАРИАНТCollections.sort(staff, (o1, o2) -> {
            int filtration = o1.getSalary().compareTo(o2.getSalary());
            return 0;
            /*int filtrationSalary = o1.getSalary().compareTo(o2.getSalary());
            if(filtrationSalary == 0) {
                int filtrationName = o1.getName().compareTo(o2.getName());
                return filtrationName;
            }
            return filtrationSalary;
        });*/

        /*Comparator<Employee> comparator = (o1,o2) -> o1.getSalary().compareTo(o2.getSalary());
        ArrayList<Employee> staff = loadStaffFromFile();
        Comparator<Employee> comparator = Comparator.comparing(o1-> o1.getSalary());
        comparator = comparator.thenComparing(o1 -> o1.getName());
        Collections.sort(staff, comparator);*/
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}