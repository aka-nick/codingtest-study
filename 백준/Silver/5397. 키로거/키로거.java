import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    private static final Character MOVE_LEFT = '<';
    private static final Character MOVE_RIGHT = '>';
    private static final Character BACKSPACE = '-';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(br.readLine());
        List<Character>[] keyLogs = new ArrayList[lineCount];
        setKeyLog(br, lineCount, keyLogs);
        br.close();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < keyLogs.length; i++) {

            ListIterator<Character> writeLines = new LinkedList<Character>().listIterator(0);
            for (int j = 0; j < keyLogs[i].size(); j++) {
                Character key = keyLogs[i].get(j);

                if (key == MOVE_LEFT) {
                    if (writeLines.hasPrevious()) {
                        writeLines.previous();
                    }
                } else if (key == MOVE_RIGHT) {
                    if (writeLines.hasNext()) {
                        writeLines.next();
                    }
                } else if (key == BACKSPACE) {
                    if (writeLines.hasPrevious()) {
                        writeLines.previous();
                        writeLines.remove();
                    }
                } else {
                    writeLines.add(key);
                }
            }

            result.append(concatLine(writeLines)).append(System.lineSeparator());
        }

        System.out.println(result);
    }

    private static String concatLine(ListIterator<Character> writeLines) {
        StringBuilder sb = new StringBuilder();
        while (writeLines.hasPrevious()) {
            writeLines.previous();
        }
        while (writeLines.hasNext()) {
            sb.append(writeLines.next());
        }
        return sb.toString();
    }

    private static void setKeyLog(BufferedReader br, int lineCount, List<Character>[] keyLogs)
            throws IOException {
        for (int i = 0; i < lineCount; i++) {
            char[] chars = br.readLine().toCharArray();
            keyLogs[i] = new ArrayList<>();
            for (int j = 0; j < chars.length; j++) {
                keyLogs[i].add(chars[j]);
            }
        }
    }

}