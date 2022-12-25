import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
n : 회의 수 (1 ~ 100000)
arr[] : "[시작시간] [종료시간]"의 반복값 (0 ~ Integer.MAX_VALUE / 1 ~ 100000개)
result - int : 수용 가능한 최대 회의 갯수를 반환
---
- 단 하나의 회의실이 존재한다.
- 회의는 겹칠 수 없고, 중단될 수 없다
- 회의는 시작하자마자 끝날 수 있다 (시작시간 == 끝나는 시간)
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (meet1, meet2) ->
            meet1[1] == meet2[1]
                    ? meet1[0] - meet2[0]
                    : meet1[1] - meet2[1]
        );

        int count = 0;
        int preEndTime = 0;
        for(int i = 0; i < n; i++) {
            if(preEndTime <= arr[i][0]) {
                preEndTime = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}