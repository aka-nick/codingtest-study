import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    private static final String MOVE_LEFT = "L";
    private static final String MOVE_RIGHT = "D";
    private static final String DELETE_LEFT = "B";
//    private static final String ADD_LEFT = "P";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ListIterator<Character> charIter = getIterator(br.readLine().toCharArray());
        int n = Integer.parseInt(br.readLine());
        List<StringTokenizer> commands = new ArrayList<>();
        setCommands(br, n, commands);
        br.close();

        for (StringTokenizer commandToken : commands) {
            String command = commandToken.nextToken();
            if (MOVE_LEFT.equals(command)) {
                if (charIter.hasPrevious()) {
                    charIter.previous();
                }
            } else if (MOVE_RIGHT.equals(command)) {
                if (charIter.hasNext()) {
                    charIter.next();
                }
            } else if (DELETE_LEFT.equals(command)) {
                if (charIter.hasPrevious()) {
                    charIter.previous();
                    charIter.remove();
                }
            } else { // ADD_LEFT.eq(command)
                char newCharacter = commandToken.nextToken().toCharArray()[0];
                charIter.add(newCharacter);
            }
        }

        StringBuilder result = concatChar(charIter);
        System.out.println(result);
    }

    private static StringBuilder concatChar(ListIterator<Character> it) {
        StringBuilder result = new StringBuilder();
        while (it.hasPrevious()) {
            it.previous();
        }
        while (it.hasNext()) {
            result.append(it.next());
        }
        return result;
    }

    private static void setCommands(BufferedReader br, int n, List<StringTokenizer> commands)
            throws IOException {
        for (int i = 0; i < n; i++) {
            commands.add(new StringTokenizer(br.readLine()));
        }
    }

    private static ListIterator<Character> getIterator(char[] arr) {
        List<Character> chars = new LinkedList<>();
        for (char c : arr) {
            chars.add(c);
        }
        ListIterator<Character> it = chars.listIterator();
        while (it.hasNext()) {
            it.next();
        }
        return it;
    }

}