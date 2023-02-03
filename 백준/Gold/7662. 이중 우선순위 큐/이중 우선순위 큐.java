import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static final String INSERT = "I";
    private static final String DELETE = "D";

    private static final int DELETE_MAX = 1;
    private static final int DELETE_MIN = -1;

    private static final String EMPTY_STRING = "EMPTY";
    private static TreeMap<Integer, Integer> mq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {

            int k = Integer.parseInt(br.readLine());
            mq = new TreeMap<>();
            while (k-- > 0) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                String com = st.nextToken();
                int comNum = Integer.parseInt(st.nextToken());

                if (com.equals(INSERT)) {
                    mq.put(comNum, mq.getOrDefault(comNum, 0) + 1);
                }
                else { // com.eq(D)
                    if (mq.isEmpty()) {
                        continue;
                    }

                    if (comNum == DELETE_MAX) {
                        int deletedValue = mq.get(mq.lastKey()) - 1;
                        if (deletedValue == 0) {
                            mq.remove(mq.lastKey());
                        }
                        else {
                            mq.put(mq.lastKey(), deletedValue);
                        }
                    }
                    else { // comNum == DEL_MIN
                        int deletedValue = mq.get(mq.firstKey()) - 1;
                        if (deletedValue == 0) {
                            mq.remove(mq.firstKey());
                        }
                        else {
                            mq.put(mq.firstKey(), deletedValue);
                        }
                    }
                }

            }
            if (mq.isEmpty()) {
                result.append(EMPTY_STRING).append(System.lineSeparator());
                continue;
            }
            result.append(mq.lastKey())
                    .append(' ')
                    .append(mq.firstKey())
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}