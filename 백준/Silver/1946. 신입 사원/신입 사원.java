import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> resultList = new ArrayList<>();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Grade[] grades = new Grade[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                grades[i] = new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 서류등수, 면접등수
            }

            Arrays.sort(grades, Comparator.comparingInt(o -> o.resume));
            int minInterview = grades[0].interview;
            int count = 1; // 1등은 무조건 통과
            for (int i = 1; i < n; i++) {
                if (grades[i].interview < minInterview) {
                    count++;
                    minInterview = grades[i].interview;
                }
            }

            resultList.add(count);
        }
        br.close();

        StringBuilder result = new StringBuilder();
        for (int r : resultList) {
            result.append(r).append(System.lineSeparator());
        }

        System.out.println(result);
    }

    static class Grade {
        int resume;
        int interview;

        public Grade(int resume, int interview) {
            this.resume = resume;
            this.interview = interview;
        }
    }
}