import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[][] persons = new int[2][6];
        for (int i = 0; i < n; i++) {
            int[] person = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            persons[person[0]][person[1] - 1]++;
        }
        br.close();

        int roomCount = 0;
        for (int i = 0; i < 2; i++) {
            for (int person : persons[i]) {
                if (person == 0) continue;
                int calc = (person - 1) / k + 1;
                roomCount += calc;
            }
        }

        System.out.println(roomCount);
    }

}