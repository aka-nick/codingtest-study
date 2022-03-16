import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i += 1) {
			int num = Integer.parseInt(sc.next());
			if (min > num) min = num;
			if (max < num) max = num;
		}
		
		sc.close();
		System.out.printf("%d %d", min, max);
	}
}