import java.util. Scanner;

public class IsSquarePair {
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int firstInt = getValidInt(scan, "Give the first integer:");
        int secondInt = getValidInt(scan, "Give the second integer:");

        System.out.println("Your pair of numbers " + (isSquarePair(firstInt, secondInt) ? "is perfect square pair!" : "is not perfect square pair!"));
        scan.close();
    }
    
    public static int getValidInt(Scanner scanner, String prompt) {
        while (true) { // Infinite loop until valid input is received
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }
    
    public static boolean isSquarePair(int first, int second){
        return ((long)first * (long)first == second) || ((long)second * (long)second == first);
    }

}
