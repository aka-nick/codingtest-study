import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int man1 = sc.nextInt();
        int man2 = sc.nextInt();

        int round = 0;

        search:
        for (int i = 2; i <= n; i *= 2) {
            round++;

            for (int j = 0; j < n; j += i) {
                int nextJ = j + i;

                if (j < man1 && man1 <= nextJ
                    && j < man2 && man2 <= nextJ) {
                    break search;
                }
            }

            if(i == n) { //마지막 비교였는데도 일치하는 라운드를 못 찾았으면, 서로 경기하지 않는 것
                round = -1;
            }
            else if (n - i < i) { //홀수 인원으로 남는 라운드였으면, 그 다음 라운드 셀 수 있도록
                round++;
            }
        }

        System.out.println(round);
    }

}
