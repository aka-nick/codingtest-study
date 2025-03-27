import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final char DELIM = '-';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String type = line[0];
        String naming = line[1];
        br.close();

        List<Character> source = toNamingSource(naming, type);

        StringBuilder camel = getCamelName(source);
        StringBuilder snake = getSnakeName(source);
        StringBuilder pascal = getPascalName(source);

        System.out.println(camel);
        System.out.println(snake);
        System.out.println(pascal);
    }

    private static List<Character> toNamingSource(String naming, String type) {
        List<Character> split = new ArrayList<>();
        char[] arr = naming.toCharArray();
        if (type.equals("1")) {
            for (int i = 0; i < arr.length; i++) {
                if ('A' <= arr[i] && arr[i] <= 'Z') {
                    split.add(DELIM);
                    arr[i] = (char) (arr[i] - 'A' + 'a');
                }
                split.add(arr[i]);
            }
        }
        else if (type.equals("2")) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '_') {
                    arr[i] = DELIM;
                }
                split.add(arr[i]);
            }
        } else { // type.eq("3")
            if ('A' <= arr[0] && arr[0] <= 'Z') {
                arr[0] = (char) (arr[0] - 'A' + 'a');
            }
            split.add(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if ('A' <= arr[i] && arr[i] <= 'Z') {
                    split.add(DELIM);
                    arr[i] = (char) (arr[i] - 'A' + 'a');
                }
                split.add(arr[i]);
            }
        }

        return split;
    }

    private static StringBuilder getCamelName(List<Character> source) {
        StringBuilder camel = new StringBuilder();
        for (int i = 0; i < source.size(); i++) {
            Character c = source.get(i);
            if (c == DELIM) {
                camel.append((char) (source.get(i + 1) - 'a' + 'A'));
                i++;
                continue;
            }
            camel.append(source.get(i));
        }
        return camel;
    }

    private static StringBuilder getSnakeName(List<Character> source) {
        StringBuilder snake = new StringBuilder();
        for (int i = 0; i < source.size(); i++) {
            Character c = source.get(i);
            if (c == DELIM) {
                snake.append('_');
                continue;
            }
            snake.append(c);
        }
        return snake;
    }

    private static StringBuilder getPascalName(List<Character> source) {
        StringBuilder pascal = new StringBuilder();
        pascal.append((char) (source.get(0) - 'a' + 'A'));
        for (int i = 1; i < source.size(); i++) {
            Character c = source.get(i);
            if (c == DELIM) {
                pascal.append((char) (source.get(i + 1) - 'a' + 'A'));
                i++;
                continue;
            }
            pascal.append(source.get(i));
        }
        return pascal;
    }

}