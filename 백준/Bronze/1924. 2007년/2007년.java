import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int d = sc.nextInt();
		sc.close();
		
		int[] months = {0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int totalDay = 0;
		for (int i = 1; i <= m; i += 1) {
			totalDay += months[i];
		}
		totalDay += d;
		
		System.out.println(days[totalDay % 7]);
		
	}
}