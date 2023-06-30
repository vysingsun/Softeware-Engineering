public class OddNumbers {
    public static void main(String[] args) {
        int start_num = 1;
        int finish_num = 500;
        System.out.print("Odd number between 0 and 500: ");
        for (int i = start_num; i < finish_num; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
