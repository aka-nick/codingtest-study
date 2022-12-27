import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ClassTime[] times = new ClassTime[n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new ClassTime(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        br.close();
        Arrays.sort(times,
                (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        PriorityQueue<Integer> endtimetable = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            if (endtimetable.isEmpty() ||
                    times[i].start < endtimetable.peek()) {
                addClassroom(endtimetable, times[i]);
            }
            else { // endtimetable.peek() <= times[i].start
                extendClassroom(endtimetable, times[i]);
            }
        }

        System.out.println(endtimetable.size());
    }

    private static void extendClassroom(PriorityQueue<Integer> timetable, ClassTime times) {
        timetable.poll();
        timetable.offer(times.end);
    }

    private static void addClassroom(PriorityQueue<Integer> timetable, ClassTime times) {
        timetable.offer(times.end);
    }

    static class ClassTime {
        int start;
        int end;

        public ClassTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

}