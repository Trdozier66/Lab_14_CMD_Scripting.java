import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileScan {
    public static void main(String[] args) {
        File file;

        if (args.length > 0) {
            // If a command-line argument is provided, use it as the file name
            file = new File(args[0]);
            if (!file.exists()) {
                System.err.println("Error: The file " + args[0] + " does not exist.");
                return;
            }
        } else {
            // Use JFileChooser if no command-line argument is provided
            JFileChooser fileChooser = new JFileChooser("src");
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            } else {
                System.out.println("File selection cancelled.");
                return;
            }
        }

        // Initialize counters
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read file line by line
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
    }
}
