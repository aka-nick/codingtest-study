import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final char REVERSE = 'R';
//    private static final char DELETE = 'D';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<TestCase> testcases = new ArrayList<>();
        setTestcases(br, t, testcases);
        br.close();

        StringBuilder result = new StringBuilder();
        for (TestCase testcase : testcases) {
            boolean isForward = true;
            boolean isErrorOccurred = false;

            for (char command : testcase.commands) {
                if (REVERSE == command) {
                    isForward = !isForward;
                }
                else { // DELETE == command
                    if (testcase.arr.isEmpty()) {
                        isErrorOccurred = true;
                        break;
                    }
                    if (isForward) {
                        testcase.arr.removeFirst();
                    }
                    else {
                        testcase.arr.removeLast();
                    }
                }
            }

            if (isErrorOccurred) {
                result.append("error");
            }
            else {
                result.append("[");

                while (0 < testcase.arr.size()) {
                    if (isForward) {
                        result.append(testcase.arr.removeFirst());
                    }
                    else {
                        result.append(testcase.arr.removeLast());
                    }

                    if (0 < testcase.arr.size()) {
                        result.append(",");
                    }
                }
                result.append("]");
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

    private static void setTestcases(BufferedReader br, int t, List<TestCase> testcases)
            throws IOException {
        for (int i = 0; i < t; i++) {
            char[] commands = br.readLine().toCharArray();
            int length = Integer.parseInt(br.readLine());
            Deque<Integer> arr = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[|,|]");
            while (st.hasMoreTokens()) {
                arr.addLast(Integer.parseInt(st.nextToken()));
            }
            testcases.add(new TestCase(commands, length, arr));
        }
    }

    static class TestCase {
        char[] commands;
        int length;
        Deque<Integer> arr;

        public TestCase(char[] commands, int length, Deque<Integer> arr) {
            this.commands = commands;
            this.length = length;
            this.arr = arr;
        }
    }

}