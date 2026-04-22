package lab2;

import java.util.Random;
import java.util.Scanner;

public class StringProcessor {
    
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--- Task 1: Digit Removal Logic ---");
        
        long randomNumber = random.nextLong() % 100000000L;
        if (randomNumber < 0) randomNumber = -randomNumber;
        
        String numberString = Long.toString(randomNumber);
        
        StringBuilder modifiedNumber = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++) {
            if (i % 2 == 1) {
                modifiedNumber.append(numberString.charAt(i));
            }
        }
        
        System.out.println("Original number: " + numberString);
        System.out.println("Modified number (removed odd positions): " + modifiedNumber);
        System.out.println("Input parameters: Random long integer, remove digits at positions 1,3,5...");
        System.out.println();
        
        System.out.println("--- Task 2: Text Analysis ---");
        
        String multiLineText = """
                Hello World! This is a test string.
                It contains 123 numbers and punctuation!!!
                Special characters: @#$%^&*()_+
                Another line with 4567 and symbols: ***???
                Final line with spaces   and tabs\t""";
        
        String longestNonLetterSequence = findLongestNonLetterSequence(multiLineText);
        
        System.out.println("Original text:");
        System.out.println(multiLineText);
        System.out.println();
        System.out.println("Longest sequence without letters: \"" + longestNonLetterSequence + "\"");
        System.out.println("Length: " + longestNonLetterSequence.length() + " characters");
        System.out.println("Input parameters: Multi-line text, find longest non-letter sequence");
        
        scanner.close();
    }
    
    private static String findLongestNonLetterSequence(String text) {
        StringBuilder currentSequence = new StringBuilder();
        String longestSequence = "";
        
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            
            if (!Character.isLetter(currentChar)) {
                currentSequence.append(currentChar);
            } else {
                if (currentSequence.length() > longestSequence.length()) {
                    longestSequence = currentSequence.toString();
                }
                currentSequence.setLength(0);
            }
        }
        
        if (currentSequence.length() > longestSequence.length()) {
            longestSequence = currentSequence.toString();
        }
        
        return longestSequence;
    }
}
