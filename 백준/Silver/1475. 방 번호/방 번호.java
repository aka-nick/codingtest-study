import java.util.Scanner;

public class Main {
    
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();
        int length = String.valueOf(input).length();
        int n = length;

        int[] set = new int[10];
        int count = 0;

        int number;
        for (int i = n; i > 0; i--) {
            number = getNthNumber(input, i);

            if (number == 6 || number == 9) {
                int other = number == 6 ? 9 : 6;

                if (isExhausted(set, number)) {
                    if (isExhausted(set, other)) {
                        addSet(set);
                        count++;
                    }
                    set[other]--;
                } else {
                    set[number]--;
                }
            } else {
                if (isExhausted(set, number)) {
                    addSet(set);
                    count++;
                }
                set[number]--;
            }
        }

        System.out.println(count);
    }

    private static boolean isExhausted(int[] set, int number) {
        if (set[number] == 0) return true;
        return false;
    }

    private static int getNthNumber(int input, int n) {
        return (input / pow10byN(n - 1)) % 10;
    }

    private static int pow10byN(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 10;
        for (int i = 1; i < n; i++) {
            result *= 10;
        }

        return result;
    }

    public static void addSet(int[] set) {
        for (int i = 0; i < 10; i++) {
            set[i] += 1;
        }
    }
    
}