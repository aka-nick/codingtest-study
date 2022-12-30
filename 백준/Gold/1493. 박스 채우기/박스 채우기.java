import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int widthOfContainer = Integer.parseInt(st.nextToken());
        int heightOfContainer = Integer.parseInt(st.nextToken());
        int lengthOfContainer = Integer.parseInt(st.nextToken());
        long volumeOfContainer = (long) widthOfContainer * heightOfContainer * lengthOfContainer;
        int n = Integer.parseInt(br.readLine());
        List<Box> boxes = new ArrayList<>();
        setBoxes(br, n, boxes);
        br.close();

        // 가장 큰 박스부터 하나씩 꺼내서
        // 컨테이너 크기와 비교하여 총 몇 개 넣을 수 있는지 계산하고,
        //  이전에 넣은 박스 수를 현재 박스수와 비교하여 제해주고(==이번에 넣은 박스 수),
        //  이번에 넣은 박스 수를 기록한다.(위에 부피 계산용 박스수랑 실제 넣은 박스수랑 별도로 기록해야 함)
        // 가장 작은 크기의 박스까지 비교작업이 끝났다면 종료
        // 들어간 박스 부피 총합과 컨테이너 부피가 동일하지 않으면 -1 리턴
        // 동일하면 실제 넣은 박스 수를 리턴

        int numberOfBoxes = 0; // 넣은 박스의 총합
        long tmpNumberOfBoxesEntered = 0; // 집어넣은 단위 박스의 개수. 최종적으로는(2^1 박스까지 계산하고 나면), 집어넣은 박스의 부피 총합이 됨
        for (int i = boxes.size() - 1; 0 <= i; i--) {
            Box box = boxes.get(i);

            long totalOfBoxesInContainer = (widthOfContainer / box.sideLength) *
                    (heightOfContainer / box.sideLength) *
                    (lengthOfContainer / box.sideLength); // 현재 박스로 꽉 채울 수 있는 박스 수
            tmpNumberOfBoxesEntered *= 8; // 이전에 넣은 박스 수 * 8 => 이전까지 넣은 박스 수를 현재 박스 크기 기준으로 변환(*8)하면 몇 개인지
            long numberOfBoxesEnteredNow = totalOfBoxesInContainer - tmpNumberOfBoxesEntered;// 꽉 채운 박스 수 - 들어가있는 박스 수 = 이번에 넣는(넣을 수 있는) 박스 수
            numberOfBoxesEnteredNow = Math.min(box.count, numberOfBoxesEnteredNow); // 진짜로 이번에 넣는 박스 수(넣을 수 있는 박스 수와 실제로 갖고 있는 박스 수를 비교)

            numberOfBoxes += numberOfBoxesEnteredNow;
            tmpNumberOfBoxesEntered += numberOfBoxesEnteredNow;
        }

        if (tmpNumberOfBoxesEntered != volumeOfContainer) {
            System.out.println(-1);
            return;
        }
        System.out.println(numberOfBoxes);
    }

    private static void setBoxes(BufferedReader br, int n, List<Box> boxes) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            boxes.add(new Box(
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    static class Box {
        long sideLength;
        long count;

        public Box(int multiplier, int count) {
            this.sideLength = (long) Math.pow(2, multiplier);
            this.count = count;
        }

        public String toString() {
            return "[ " + this.sideLength + " / " + this.count + " ]";
        }
    }

}