import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTimeFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter date and time (yyyy-MM-dd HH:mm:ss):");
        String input = sc.nextLine();

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = inputFormat.parse(input);

            SimpleDateFormat outputFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            SimpleDateFormat outputFormat2 = new SimpleDateFormat("EEEE, dd MMMM yyyy");
            SimpleDateFormat outputFormat3 = new SimpleDateFormat("hh:mm a");

            System.out.println("\n--- FORMATTED OUTPUT ---");
            System.out.println("Format 1: " + outputFormat1.format(date));
            System.out.println("Format 2: " + outputFormat2.format(date));
            System.out.println("Format 3: " + outputFormat3.format(date));

        } catch (Exception e) {
            System.out.println("Invalid date format!");
        }

        sc.close();
    }
}
