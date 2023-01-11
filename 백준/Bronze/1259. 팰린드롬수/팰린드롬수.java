import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> ints = new ArrayList<>();
        while (true) {
            String numStr = br.readLine();
            if ("0".equals(numStr)) {
                break;
            }
            ints.add(numStr.toCharArray());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        arr:
        for (char[] arr : ints) {
            for (int front = 0; front < arr.length / 2; front++) {
                int back = arr.length - front - 1;

                if (arr[front] != arr[back]) {
                    result.append("no").append(System.lineSeparator());
                    continue arr;
                }
            }
            result.append("yes").append(System.lineSeparator());
        }

        System.out.println(result);
    }

}