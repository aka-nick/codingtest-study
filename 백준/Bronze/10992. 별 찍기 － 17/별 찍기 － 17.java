import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i = 1; i <= n; i += 1) {
			
			for (int j = n - 1; j >= i; j -= 1) sb.append(' ');
			
			for (int j = 1; j <= i * 2 - 1; j += 1) {
				char tmp = (i == n || j == 1 || j == i * 2 - 1) ? '*' : ' ';
				sb.append(tmp);				
			}
			sb.append('\n');
		}
		
		System.out.print(sb.toString());
	}
}