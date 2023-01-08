import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<TowerInfo> outgoingTowers = new ArrayList<>();
        setTowers(br, n, outgoingTowers);
        br.close();

        Deque<TowerInfo> receivingTowers = new ArrayDeque<>();
        int seq = 0;
        StringBuilder result = new StringBuilder();
        while (seq < n) {
            TowerInfo outgoingTower = outgoingTowers.get(seq);

            if (receivingTowers.isEmpty()) {
                logForNoOneReceived(result);
                seq = transmissionCompleted(receivingTowers, seq, outgoingTower);
                continue;
            }

            TowerInfo receivingTower = receivingTowers.peek();
            if (receivingTower.height < outgoingTower.height) {
                receivingTowers.pop();
                continue;
            }

            logForReceiveTower(receivingTower.idx, result);
            seq = transmissionCompleted(receivingTowers, seq, outgoingTower);
        }

        System.out.println(result);
    }

    private static void logForReceiveTower(int receivingTowerIdx, StringBuilder result) {
        result.append(receivingTowerIdx).append(DELIMITER);
    }

    private static int transmissionCompleted(Deque<TowerInfo> receivingTowers, int seq, TowerInfo outgoingTower) {
        receivingTowers.push(outgoingTower);
        seq += 1;
        return seq;
    }

    private static void logForNoOneReceived(StringBuilder result) {
        result.append(0).append(DELIMITER);
    }

    private static void setTowers(BufferedReader br, int n, List<TowerInfo> towers)
            throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            towers.add(new TowerInfo(i + 1, Integer.parseInt(st.nextToken())));
        }
    }

    static class TowerInfo {
        int idx;
        int height;

        public TowerInfo(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}