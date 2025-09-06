import java.util.Arrays;

public class FindMaxNumberInArray{
    public static int findMaxNumber(int[] arr){
        int maxNumber = Integer.MIN_VALUE;
        if (arr == null|| arr.length == 0){
            System.out.println("The array must not be empty!");
        }
        else{
            
            for (int i=0; i< arr.length; i++){
                if (arr[i]> maxNumber){
                    maxNumber = arr[i];
                }
            }  
        } 
        return maxNumber;  
    }

    public static void main(String[] args){
        int[][] testArrays = {
            {},
            {5},
            {5, 5, 5, 5, 5},
            {9, 0, -1, -12, 6},
            {3, 9, 12, 5, 18, 67, 32}};
        for (int[] arr : testArrays){
            System.out.println("The maximum number in the array " + Arrays.toString(arr) + " is: " +findMaxNumber(arr));
        }
    }    
}