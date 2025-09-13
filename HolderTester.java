public class HolderTester {
    public static void main(String[] args){

    Holder<Integer> intHolder = new Holder<>(7, 9);
    Holder<String> stringHolder = new Holder<>("I'm", "a programmer now");

    System.out.println(intHolder); 
    System.out.println(stringHolder);
    }
}
