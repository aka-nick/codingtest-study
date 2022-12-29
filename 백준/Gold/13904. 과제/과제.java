import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Homework> homeworks = new LinkedList<>();
        setHomeworks(br, n, homeworks);
        br.close();

        int maxDay = getMaxDay(homeworks);
        int totalScore = 0;
        for (int day = maxDay; 0 < day ; day--) {
            totalScore += getMaxScore(homeworks, day);
        }

        System.out.println(totalScore);
    }

    private static void setHomeworks(BufferedReader br, int n, List<Homework> homeworks)
            throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            homeworks.add(new Homework(deadline, score));
        }
        homeworks.sort((o1, o2) -> o2.score - o1.score);
    }
    
    private static int getMaxDay(List<Homework> homeworks) {
        int maxDay = 0;
        for (Homework homework : homeworks) {
            maxDay = Integer.max(maxDay, homework.deadline);
        }
        return maxDay;
    }

    private static int getMaxScore(List<Homework> homeworks, int day) {
        int maxScore = 0;
        for (int i = 0; i < homeworks.size(); i++) {
            Homework homework = homeworks.get(i);
            if (day <= homework.deadline) {
                maxScore = homework.score;
                homeworks.remove(i);
                break;
            }
        }
        return maxScore;
    }

    static class Homework {
        int deadline;
        int score;

        public Homework(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }
    }
}