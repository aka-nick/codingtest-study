import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int loop = 1;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i = 1; i < n; i += 1) {
			n -= i;
			loop += 1;
		}
		
		int bj = n;
		int bm = loop - n + 1;
		if (loop % 2 != 0) {
			bm = n;
			bj = loop - n + 1;
		}
		
		System.out.printf("%d/%d", bj, bm);
    }
}