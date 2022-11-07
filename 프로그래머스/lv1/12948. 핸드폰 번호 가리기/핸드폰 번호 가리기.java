import java.util.*;

class Solution {
    
    public String solution(String phone_number) {
        
        int maskLength = phone_number.length() - 4;
        String maskString = makeMask(maskLength);
        return maskString + phone_number.substring(maskLength);
    }
    
    private String makeMask(int maskLength) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maskLength; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}