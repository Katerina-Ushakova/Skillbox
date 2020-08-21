import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static java.time.LocalDate.*;

public class Main {
    public static void main (String[] args) {
        LocalDate todayDate = now();
        LocalDate birthday = of(1998, Month.AUGUST, 17);
        LocalDate currrentBirthday = birthday;
        
        for (int i = 0; currrentBirthday.isBefore(todayDate); i++ ) {
            System.out.println("День рождения № " + i + ": " + currrentBirthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy.E")) );
            currrentBirthday = currrentBirthday.plusYears(1);
        }
        }
    }

