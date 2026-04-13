import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AttendanceReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the attendance file name:");

        String fileName = scanner.nextLine();

        int presentCount = 0;
        int absentCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            System.out.println("\n===== ATTENDANCE REPORT =====");

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {

                    String[] parts = line.split(",");

                    if (parts.length == 2) {

                        String name = parts[0].trim();
                        String status = parts[1].trim().toUpperCase();

                        if (status.equals("P")) {
                            System.out.println(name + " -> Present");
                            presentCount++;
                        } else if (status.equals("A")) {
                            System.out.println(name + " -> Absent");
                            absentCount++;
                        } else {
                            System.out.println("Invalid status for: " + name);
                        }

                    } else {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }

            reader.close();

            System.out.println("\nTotal Present: " + presentCount);
            System.out.println("Total Absent: " + absentCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
