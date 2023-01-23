import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (tc-- > 0) {
            String s = br.readLine();
            if (s.length() == 0) {
                tc++;
                continue;
            }
            StringTokenizer st = new StringTokenizer(s);
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            result.append(getHotelRoomNumber(h, w, n)).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

    private static String getHotelRoomNumber(int h, int w, int n) {
        int floorNumber = 0;
        if (n % h == 0) {
            floorNumber = h;
        }
        else {
            floorNumber = n % h;
        }
        int roomNumber = ((n - 1) / h) + 1;
        return floorNumber + String.format("%02d", roomNumber);
    }

}