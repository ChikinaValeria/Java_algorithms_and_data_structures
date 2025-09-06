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
        System.out.println(findMaxNumber(new int[]{4, 7, 1, 89, 13}));
    }
}