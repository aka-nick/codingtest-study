import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder builder = new StringBuilder();
        builder
                .append(BigDecimal.valueOf(r * r * Math.PI).setScale(6, RoundingMode.HALF_UP))
                .append(System.lineSeparator())
                .append(BigDecimal.valueOf((long) r * r * 2).setScale(6, RoundingMode.HALF_UP));

        System.out.println(builder);
    }

}