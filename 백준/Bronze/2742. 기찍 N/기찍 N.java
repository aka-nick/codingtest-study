import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for (int i = n; i >= 1; i -= 1) {			
			sb.append(i).append('\n');
		}
		
		sc.close();
		System.out.print(sb.toString());
	}
}