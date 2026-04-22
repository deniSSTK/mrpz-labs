package lab4;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {
    
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== File I/O Phone Records Processor ===");
        System.out.println();
        
        System.out.print("Enter source file path: ");
        String sourceFile = scanner.nextLine();
        
        System.out.print("Enter destination file path: ");
        String destinationFile = scanner.nextLine();
        
        System.out.print("Enter starting letters (comma-separated, e.g., K,S): ");
        String lettersInput = scanner.nextLine();
        String[] startingLetters = lettersInput.split(",");
        
        for (int i = 0; i < startingLetters.length; i++) {
            startingLetters[i] = startingLetters[i].trim().toUpperCase();
        }
        
        try {
            System.out.println("Opening source file...");
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            
            System.out.println("Reading data...");
            String line;
            int recordsProcessed = 0;
            int recordsFiltered = 0;
            
            System.out.println("Filtering records...");
            System.out.println("Opening destination file...");
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));
            
            while ((line = reader.readLine()) != null) {
                recordsProcessed++;
                line = line.trim();
                
                if (line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        String surname = parts[0].trim();
                        String phone = parts[1].trim();
                        
                        for (String letter : startingLetters) {
                            if (surname.toUpperCase().startsWith(letter)) {
                                writer.write(phone + " - " + surname);
                                writer.newLine();
                                recordsFiltered++;
                                break;
                            }
                        }
                    }
                }
            }
            
            reader.close();
            writer.close();
            
            System.out.println("Writing to result file...");
            System.out.println("Task completed successfully!");
            System.out.println("Total records processed: " + recordsProcessed);
            System.out.println("Records filtered and written: " + recordsFiltered);
            System.out.println("Results saved to: " + destinationFile);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: I/O Exception - " + e.getMessage());
        }
        
        scanner.close();
    }
}
