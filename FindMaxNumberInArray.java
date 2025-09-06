import java.util.Arrays;
import java.util.Random;

public class FindMaxNumberInArray{
    public static int findMaxNumber(int[] arr){
        int maxNumber = Integer.MIN_VALUE;
        if (arr == null|| arr.length == 0){
            throw new IllegalArgumentException("Array must not be empty");
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

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        Random random = new Random();
        int arraySize = random.nextInt(maxSize + 1);
        int[] newArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            newArray[i] = random.nextInt(maxValue*2) - maxValue;
        }
        return newArray;
    }

    public static void main(String[] args){
        int[][] testArrays = {
                {},
                null,
                {5},
                {5, 5, 5, 5, 5},
                {9, 0, -1, -12, 6},
                {3, 9, 12, 5, 18, 67, 32},
                {3, 5, 7, 9, 11, 13}
            };
        for (int[] arr : testArrays){
                try{
                    System.out.println("The maximum number in the array " + Arrays.toString(arr) + " is: " +findMaxNumber(arr));
                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }    
        }

        System.out.println("Let's add some random arrays:");
        for (int i = 0; i < 3; i++){
            int[] randomArray = generateRandomArray(15, 200);
            try{
                System.out.println("The maximum number in the array " + Arrays.toString(randomArray) + " is: " + findMaxNumber(randomArray));
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }    
}