import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> rs = new ArrayList<>();
        List<char[]> stringChars = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            rs.add(Integer.parseInt(st.nextToken()));
            stringChars.add(st.nextToken().toCharArray());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rs.size(); i++) {
            char[] chars = stringChars.get(i);
            for (char aChar : chars) {
                for (int j = 0; j < rs.get(i); j++) {
                    result.append(aChar);
                }
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

}