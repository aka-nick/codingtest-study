import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> mods = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            mods.add(Integer.parseInt(br.readLine()) % 42);
        }
        br.close();

        System.out.println(mods.size());
    }

}