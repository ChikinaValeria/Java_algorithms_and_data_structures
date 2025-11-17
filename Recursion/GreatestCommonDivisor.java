package Recursion;

public class GreatestCommonDivisor{

    public static int gcd(int x, int y) {
        // Base case: If y is 0, the GCD is x.
        if (y == 0) {
            return x;
        }

        // Recursive step: GCD(x, y) is the same as GCD(y, x % y).
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        int result1 = gcd(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + result1);

        int num3 = 105;
        int num4 = 45;
        int result2 = gcd(num3, num4);
        System.out.println("The GCD of " + num3 + " and " + num4 + " is: " + result2);

        //base case test
        int num5 = 99;
        int num6 = 0;
        int result3 = gcd(num5, num6);
        System.out.println("The GCD of " + num5 + " and " + num6 + " is: " + result3);
    }



}