import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatesDemo {
    public static void main(String[] args) {
        //LocalDate - sama data
        //LocalTime - sama godzina
        //LocalDateTime - data z godziną
        //local bierze się z tego że jest z konkretnej strefy czasowej
        //Instant - konkretny moment w czasie niezależny od strefy


        LocalDate localDate = LocalDate.of(2023, 2, 1);
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(localDate.isBefore(now));
        System.out.println(localDate.until(now));
        now = now.minusWeeks(1);
        System.out.println(now.getDayOfWeek());


        if (now.getDayOfWeek() == DayOfWeek.THURSDAY){
            System.out.println("Tak");
        } else {
            System.out.println("Nie");
        }


        System.out.println(LocalTime.now());


        System.out.println(LocalDateTime.now());
    }
}
