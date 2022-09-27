package labor4;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        try {
            System.out.println(numbers[5]);
        } catch (Exception e) {
            throw new IndexNotFoundException("Bad index");
        }
    }
}
