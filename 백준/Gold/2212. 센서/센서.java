import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> sensors = getSensorPositions(n, st);
        br.close();

        int[] diff = getDiff(n, sensors);

        int result = 0;
        int excludeDiffPoints = k - 1;
        for (int i = 0; i < diff.length - excludeDiffPoints; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }

    private static int[] getDiff(int n, List<Integer> sensors) {
        int[] diff = new int[n - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = sensors.get(i + 1) - sensors.get(i);
        }
        Arrays.sort(diff);
        return diff;
    }

    private static List<Integer> getSensorPositions(int n, StringTokenizer st) {
        List<Integer> sensors = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sensors.add(Integer.parseInt(st.nextToken()));
        }
        sensors.sort(Comparator.comparingInt(o -> o));
        return sensors;
    }

}