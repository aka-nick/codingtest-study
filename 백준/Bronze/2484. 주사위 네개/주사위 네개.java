import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        while (n-- > 0) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Integer[] scores = new Integer[7];
            Integer[] dices = new Integer[7];
            Arrays.fill(scores, 0);
            Arrays.fill(dices, 0);
            scores[line[0]] += 1;
            scores[line[1]] += 1;
            scores[line[2]] += 1;
            scores[line[3]] += 1;
            dices[line[0]] += 1;
            dices[line[1]] += 1;
            dices[line[2]] += 1;
            dices[line[3]] += 1;

            Arrays.sort(scores, Comparator.reverseOrder());

            int rank = 5;
            if (scores[0] == 4) {
                rank = 1;
            } else if (scores[0] == 3) {
                rank = 2;
            } else if (scores[0] == 2 && scores[1] == 2) {
                rank = 3;
            } else if (scores[0] == 2) {
                rank = 4;
            }

            int prize = 0;
            if (rank == 1) {
                for (int eye = 1; eye <= 6; eye++) {
                    if (!dices[eye].equals(scores[0])) continue;
                    prize += eye * 5_000 + 50_000;
                    break;
                }
            } else if (rank == 2) {
                for (int eye = 1; eye <= 6; eye++) {
                    if (!dices[eye].equals(scores[0])) continue;
                    prize += eye * 1_000 + 10_000;
                    break;
                }
            } else if (rank == 3) {
                for (int eye = 1; eye <= 6; eye++) {
                    if (!dices[eye].equals(scores[0])) continue;
                    prize += eye * 500;
                }
                prize += 2_000;
            } else if (rank == 4) {
                for (int eye = 1; eye <= 6; eye++) {
                    if (!dices[eye].equals(scores[0])) continue;
                    prize += eye * 100;
                    break;
                }
                prize += 1_000;
            } else {
                for (int eye = 6; 1 <= eye; eye--) {
                    if (dices[eye] < 1) continue;
                    prize += eye * 100;
                    break;
                }
            }

            max = Math.max(max, prize);
        }
        br.close();

        System.out.println(max);
    }

}