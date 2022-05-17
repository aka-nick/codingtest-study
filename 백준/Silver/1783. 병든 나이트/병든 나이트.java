import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int footprint = 0;
        
        if (n == 1) 
            footprint = 1;  // n이 1이면 움직일 수가 없다
        else if (n == 2) 
            footprint = (m + 1) / 2 > 4 ? 4 : (m + 1) / 2; //n이 2면 (m + 1) / 2번만 움직일 수 있다. 그것도 최대 4칸까지만(5칸부터는 이동방법 제약이 있으니까)
        else
            if (m < 7) // m이 7이 안되면
                footprint = m > 4 ? 4 : m; // 무조건 가로로 한칸씩 움직인다. 그것도 최대 4칸까지만 (5칸부터는 이동방법 제약이 있으니까)
            else // m이 7이상이면
                footprint = m - 2; // '네가지 이동방법 만족' 조건을 만족한다. 조건을 만족하는 위치(7), 조건을 만족한 발자국 수(5)를 감안하면 m - 7 + 5, 즉 m - 2가 된다.
            
        System.out.println(footprint);
    }
}