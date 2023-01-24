import java.util.Scanner;

public class Main {

    private static int COUNT = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        StringBuilder result = new StringBuilder();
        hanoi(n, 1, 3, result);

        System.out.println(COUNT);
        System.out.println(result);
    }

    private static void hanoi(int n, int start, int end, StringBuilder result) {
        if (n == 1) {
            move(n, start, end, result);
            return;
        }

        int other = 6 - start - end;
        hanoi(n - 1, start, other, result);
        move(n, start, end, result);
        hanoi(n - 1, other, end, result);
    }

    private static void move(int n, int origin, int destination, StringBuilder result) {
        COUNT++;
        result.append(origin).append(' ').append(destination).append(System.lineSeparator());
    }

}