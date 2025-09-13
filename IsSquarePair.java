import java.util. Scanner;

public class IsSquarePair {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        System.out.println(" Give the first integer:");
        int firstInt = Integer.parseInt(scan.nextLine());

        System.out.println(" Give the second integer:");
        int secondInt = Integer.parseInt(scan.nextLine());

        System.out.println("Your pair of numbers " + (isSquarePair(firstInt, secondInt) ? "is perfect square pair!" : "is not perfect square pair!"));
        scan.close();
    }
    
    public static boolean isSquarePair(int first, int second){
        if (first*first == second || second*second == first){
            return true;
        }else{
            return false;
        }    
        
    }

}
