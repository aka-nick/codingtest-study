import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();
        List<Integer> holes = new ArrayList<>();
        while (st.hasMoreTokens()) {
            holes.add(Integer.valueOf(st.nextToken()));
        }
        holes.sort(Comparator.comparingInt(o -> o));

        int extraLength = 1;
        int count = 0;
        int firstHole = 0;
        while (!holes.isEmpty()) {
            int secondHole = holes.remove(0);

            if (firstHole == 0) { // 첫 테이프 사용하는 경우
                count++;
                firstHole = secondHole;
                continue;
            }

            if (l < secondHole - firstHole + extraLength) { // 새 테이프 사용하게 되는 경우
                count++;
                firstHole = secondHole;
            }

        }

        System.out.println(count);
    }

}