import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Node[] mem;
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        br.close();

        mem = new Node[x + 1];
        mem[1] = new Node(0, 0);
        for (int i = 1; i <= x; i++) {
            Node now = mem[i];
            int nowCnt = now.cntOp + 1;

            operateMem(i + 1, i);
            operateMem(i * 2, i);
            operateMem(i * 3, i);
        }

        StringBuilder result = new StringBuilder();
        result.append(mem[x].cntOp).append(System.lineSeparator())
                .append(x).append(' ');
        while (1 < x) {
            x = mem[x].from;
            result.append(x).append(' ');
        }
        System.out.println(result);
    }

    private static void operateMem(int nextIdx, int nowIdx) {
        Node nowNode = mem[nowIdx];

        if (x < nextIdx) {
            return;
        }

        if (mem[nextIdx] == null || nowNode.cntOp + 1 < mem[nextIdx].cntOp) {
            mem[nextIdx] = new Node(nowNode.cntOp + 1, nowIdx);
        }
    }

    static class Node {
        int cntOp;
        int from;

        public Node(int countOperation, int from) {
            this.cntOp = countOperation;
            this.from = from;
        }
    }
    
}