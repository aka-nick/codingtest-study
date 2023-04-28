import java.util.*;
import java.util.stream.*;
import java.math.*;

class Solution {

    public int solution(int[] arr) {
        return Arrays.stream(arr)
                .reduce(1, this::lcm);
    }

    int gcd(int a, int b) {
        BigInteger aa = BigInteger.valueOf((long) a);
         BigInteger bb = BigInteger.valueOf((long) b);
        return aa.gcd(bb).intValue();
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}