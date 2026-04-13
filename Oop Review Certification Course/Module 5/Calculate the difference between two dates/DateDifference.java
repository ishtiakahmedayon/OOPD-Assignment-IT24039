import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifference {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (YYYY-MM-DD): ");
        String date1 = sc.nextLine();

        System.out.print("Enter second date (YYYY-MM-DD): ");
        String date2 = sc.nextLine();

        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        long days = ChronoUnit.DAYS.between(d1, d2);
        long months = ChronoUnit.MONTHS.between(d1, d2);
        long years = ChronoUnit.YEARS.between(d1, d2);

        System.out.println("\n--- RESULT ---");
        System.out.println("Difference in days: " + Math.abs(days));
        System.out.println("Difference in months: " + Math.abs(months));
        System.out.println("Difference in years: " + Math.abs(years));

        sc.close();
    }
}
