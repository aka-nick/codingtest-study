import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i = n; i >= 1; i -= 1) {
			for (int j = 0; j < n - i; j += 1) {				
				sb.append(' ');
			}
			for (int j = 1; j <= i; j += 1) {				
				sb.append("*");
			}
			sb.append('\n');
		}
		
		System.out.print(sb.toString());
	}
}