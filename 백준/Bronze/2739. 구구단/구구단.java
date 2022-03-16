import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		
		for (int i = 1; i <= 9; i += 1) {			
			sb.append(n).append(" * ").append(i).append(" = ").append(n * i).append('\n');
		}
		
		sc.close();
		System.out.print(sb.toString());
	}
}