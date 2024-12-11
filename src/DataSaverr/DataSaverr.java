package DataSaverr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaverr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean addMore = true;
        while (addMore) {
            // Collect user data
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter ID Number (e.g., 000001): ");
            String idNumber = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Year of Birth (e.g., 1978): ");
            String yearOfBirth = scanner.nextLine();

            // Create CSV record and add to list
            String record = firstName + "," + lastName + "," + idNumber + "," + email + "," + yearOfBirth;
            records.add(record);

            // Check if the user wants to add more records
            System.out.print("Add another record? (yes/no): ");
            String response = scanner.nextLine();
            addMore = response.equalsIgnoreCase("yes");
        }

        // Ask for file name to save the data
        System.out.print("Enter the file name to save (with .csv extension): ");
        String fileName = scanner.nextLine();

        // Write records to the specified CSV file
        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

