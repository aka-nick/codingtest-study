import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.valueOf(line);
		
		for (int i = 0; i < n; i += 1) {
			line = br.readLine();
			System.out.println(Integer.valueOf(line.split(",")[0]) + Integer.valueOf(line.split(",")[1]));
		}
		
		br.close();
	}
}