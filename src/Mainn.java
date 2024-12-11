import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Mainn {
    public static void main(String[] args) {
        // Initialize JFileChooser and set directory to src
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;

                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                    System.out.println(line); // Echo each line
                }

                // Print summary report
                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + file.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("File selection cancelled.");
        }
    }
}
