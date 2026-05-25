import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the list: ");
        int size = scanner.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            list.add(scanner.nextInt());
        }
        
        System.out.println("Original list: " + list);
        
        System.out.print("Enter the number of positions to shift right (N): ");
        int n = scanner.nextInt();
        
        if (n < 0 || n >= size) {
            System.out.println("Invalid N. N must be between 0 and " + (size - 1));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            Integer last = list.remove(list.size() - 1);
            list.add(0, last);
        }
        
        System.out.println("Modified list after cyclic right shift by " + n + " positions: " + list);
        
        scanner.close();
    }
}
