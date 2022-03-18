import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int loop = 1;
		
		for (int i = 1; i < n; i += 1) {
			n -= i;
			loop += 1;
		}
		
		int bj,bm;
		if (loop % 2 == 0) {			
			bj = n;
			bm = loop - n + 1;
		}
		else {
			bm = n;
			bj = loop - n + 1;
		}
		
		System.out.printf("%d/%d", bj, bm);
    }
}