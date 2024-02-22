import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Resistance r1 = Resistance.find(br.readLine());
        Resistance r2 = Resistance.find(br.readLine());
        Resistance r3 = Resistance.find(br.readLine());
        br.close();
        long calculatedResistance = Resistance.calculate(r1, r2, r3);
        System.out.println(calculatedResistance);
    }

    enum Resistance {
        BLACK("black", 0, 1),
        BROWN("brown", 1, 10),
        RED("red", 2, 100),
        ORANGE("orange", 3, 1_000),
        YELLOW("yellow", 4, 10_000),
        GREEN("green", 5, 100_000),
        BLUE("blue", 6, 1_000_000),
        VIOLET("violet", 7, 10_000_000),
        GREY("grey", 8, 100_000_000),
        WHITE("white", 9, 1_000_000_000),
        ;

        private String color;
        private long value;
        private long multiply;

        Resistance(String color, long value, long multiply) {
            this.color = color;
            this.value = value;
            this.multiply = multiply;
        }

        public static Resistance find(String color) {
            return Arrays.stream(values())
                    .filter(r -> r.color.equals(color))
                    .findFirst()
                    .orElseThrow();
        }
        public static long calculate(
                Resistance r1,
                Resistance r2,
                Resistance r3
        ) {
            long inputValue = Long.parseLong("" + r1.value + r2.value);
            return inputValue * r3.multiply;
        }
    }

}