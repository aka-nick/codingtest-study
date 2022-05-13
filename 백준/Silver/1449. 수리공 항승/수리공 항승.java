import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //상황 설정 시작---
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n: 빵꾸 갯수
        int m = sc.nextInt(); // m: 테이프 미터(길이)
        sc.nextLine();
        boolean isSequantial = true; // 구멍 위치를 순차적으로 입력중이니?
        int[] ns = new int[n]; //빵꾸들 위치 저장용
        for (int i = 0; i < n ; i++) { //순차적인지 확인하는 loop
            int nowN = sc.nextInt();
            if (isSequantial && i > 0) isSequantial = ns[i - 1] < nowN ? true : false;
            ns[i] = nowN;
        }
        if (!isSequantial) Arrays.sort(ns); // 구멍의 위치 정보를 왼쪽(1)부터 마지막(n)까지 순서대로 나열; 순서대로가 아닐 때에만
        //---상황 설정 끝

        
        /*
        * 새로운 아이디어(주하님 코드를 읽고나서): 꼭 파이프를 다 훑을 필요 없다(굳이 o(n)의 시간을 쓸 필요가 없다). 세어만 보면 되니까.
        */
        int cnt = 0;        // 몇개 썼나
        int tapeTail = 0;   // 테이프 길이
        for (int nowN : ns) {           // 구멍 위치를 하나씩 확인하며
            if (nowN > tapeTail) {      // '테이프로 메꿔진 마지막 구멍(위치)'보다 더 뒤에 구멍이 등장하면
                tapeTail = nowN + m - 1;    // '테이프로 메꿔진 마지막 위치'를 새롭게 체크하고(새롭게 테이프를 붙이고)
                cnt++;                      // 붙였으니까 카운트.
            }
        }
        
        System.out.println(cnt);
    }
}
