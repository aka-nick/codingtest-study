import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String numbers = sc.next();
		int total = 0;
		for (int i = 0; i < n; i += 1) {
//			total += numbers.charAt(i) - '0';
			total += Character.digit(numbers.charAt(i), 10);
		}
		
		sc.close();
		System.out.println(total);
	}
}