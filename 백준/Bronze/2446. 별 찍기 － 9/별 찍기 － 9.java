import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= n; i += 1) {
			for (int j = 1; j < i; j += 1) {
				sb.append(' ');
			}
			for (int j = (n - i + 1) * 2 - 1; j >= 1; j -= 1) {
				sb.append('*');				
			}
			sb.append('\n');
		}
		for (int i = n - 1; i >= 1; i -= 1) {
			
			for (int j = 1; j < i; j += 1) {
				sb.append(' ');
			}
			for (int j = (n - i + 1) * 2 - 1; j >= 1; j -= 1) {
				sb.append('*');				
			}
			sb.append('\n');
		}
		
		System.out.print(sb.toString());
	}
}