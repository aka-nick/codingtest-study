import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] votes = new int[2];
        while (n-->0) {
            int vote = Integer.parseInt(br.readLine());
            votes[vote]++;
        }
        br.close();

        System.out.println(votes[0] > votes[1] 
                ? "Junhee is not cute!" : "Junhee is cute!");
    }

}