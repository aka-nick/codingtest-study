import static java.math.BigInteger.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            BigInteger n = new BigInteger(line);
            BigInteger base = ZERO;
            while (true) {
                base = base.multiply(TEN).add(ONE);
                if (base.mod(n).equals(ZERO)) {
                    result
                            .append(base.toString().length())
                            .append(System.lineSeparator());
                    break;
                }
            }
        }
        br.close();

        System.out.println(result);
    }

}