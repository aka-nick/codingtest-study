import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int n = 0;
	static int s = 0;
	static int[] arr;
	static int sum = 0;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		sc.nextLine();
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, 0);
		
		System.out.println(count);
	}
	
	private static void perm(int depth, int start) {
		if (depth == n) {
			return;
		}
		
		for (int i = start; i < n; i++) {
			sum += arr[i];
			if (sum == s) count++;
			
			perm(depth + 1, i + 1);
			
			sum -= arr[i];
		}
	}
}
