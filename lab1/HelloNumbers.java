package W01;

public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int a = 0;
        while (x < 46) {
            System.out.print(x + " ");
            x = x + a + 1;
            a = a + 1;
        }
    }
}
