import java.util.Arrays;

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

    public static void main(String[] args){
        int[][] testArrays = {
                {},
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
    }    
}