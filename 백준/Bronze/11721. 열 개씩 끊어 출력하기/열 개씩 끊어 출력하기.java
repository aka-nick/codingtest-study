import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		StringBuffer sb = new StringBuffer();
		int unitLength = 10;

		for (int i = 0; i < line.length(); i += unitLength) {
			if (i + unitLength > line.length()) {				
				sb.append(line.substring(i));
				break;
			}
			sb.append(line.substring(i, i + unitLength)).append("\n");
		}
		
		sc.close();
		System.out.print(sb.toString());
	}
}