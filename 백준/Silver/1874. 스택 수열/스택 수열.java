import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sequence.add(Integer.valueOf(br.readLine()));
        }
        br.close();

        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        //1부터 n까지의 숫자를 stValue라 하여 stack에 push
        int sequenceIdx = 0;
        int nowValue = sequence.get(sequenceIdx).intValue();
        for (int stValue = 1; stValue <= n; stValue++) {
            stack.push(stValue);
            result.append("+").append(System.lineSeparator());

            //stack.peek()와 이번 수열nowSeq가 같아진 동안 stack에서 pop
            while (!stack.isEmpty() && stack.peek().intValue() == nowValue) {
                stack.pop();
                result.append("-").append(System.lineSeparator());
                if (sequenceIdx + 1 < sequence.size()) {
                    nowValue = sequence.get(++sequenceIdx).intValue();
                }
            }
        }

        //모든 작업을 마치고 비어있지 않으면 실패
        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }

        // 성공했으면 결과 출력
        System.out.print(result);
    }

}