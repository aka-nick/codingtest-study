import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 n개를 담는다
        // 기호 n-1개를 담는다
        // 0번째 기호부터 꺼내면서
        // 계속 더해주다가
        // 빼기가 등장하면, 그 숫자부터는 다 뺀다.
        String equation = br.readLine();
        br.close();

        // 숫자 n개를 담는다
        List<Integer> numbers = new ArrayList<>();
        addNumbers(equation, numbers);

        // 기호 n-1개를 담는다
        List<Character> operators = new ArrayList<>();
        addOperators(equation, operators);

        // 연산자들을 탐색하면서
        // 기본적으로는 numbers.get(i+1)를 더해주는데
        // i번째에 -가 등장하면 그때부터는 전부 빼준다
        int sum = numbers.get(0);
        boolean isAppearMinus = false;
        for (int i = 0; i < operators.size(); i++) {

            // 마이너스가 처음 등장했으면, 마이너스 상태 변경
            isAppearMinus = checkAppearMinus(operators.get(i), isAppearMinus);

            //  기호가 +이면(마이너스가 등장한 적 없으면), 그냥 계속 더한다
            if (!isAppearMinus) {
                sum += numbers.get(i + 1);
            }
            else {
                sum -= numbers.get(i + 1);
            }

        }

        System.out.println(sum);
    }

    private static boolean checkAppearMinus(char operator, boolean isAppearMinus) {
        if (!isAppearMinus && operator == '-') {
            isAppearMinus = true;
        }
        return isAppearMinus;
    }

    private static void addOperators(String equation, List<Character> operators) {
        for (char c : equation.toCharArray()) {
            if (c == '+' || c == '-') {
                operators.add(c);
            }
        }
    }

    private static void addNumbers(String equation, List<Integer> numbers) {
        StringTokenizer st = new StringTokenizer(equation, "+|-");
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
    }
    
}