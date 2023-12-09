import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int fromHour = Integer.parseInt(time[0]);
        int fromMinute = Integer.parseInt(time[1]);
        int fromSecond = Integer.parseInt(time[2]);
        int during = Integer.parseInt(br.readLine());
        br.close();

        int from = (fromHour * 3600) + (fromMinute * 60) + fromSecond;
        int to = from + during;

        int toHour = to / 3600 % 24;
        int toMinute = to % 3600 / 60;
        int toSecond = to % 3600 % 60;

        System.out.printf("%d %d %d", toHour, toMinute, toSecond);
    }

}