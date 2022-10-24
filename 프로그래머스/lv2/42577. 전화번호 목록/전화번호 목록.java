import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        if (phone_book.length == 1) return true;
        
        Arrays.sort(phone_book, (s1, s2) -> s2.length() - s1.length());
        Map<String, Boolean> map = new HashMap<>();
        boolean result = true;
        
        int prelength = -1;
        
        for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            int nextPhoneLength = phone.length();
            if (i + 1 < phone_book.length) {
                nextPhoneLength = phone_book[i + 1].length();
            }
            
            if (prelength == phone.length()) {
                
                if (map.containsKey(phone)) {
                    result = false;
                    break;
                }
                putMap(map, nextPhoneLength, phone);
                continue;
            }
            prelength = phone.length();
            
            if (map.containsKey(phone)) {
                result = false;
                break;
            }        
            putMap(map, nextPhoneLength, phone);
        }
        
        return result;
    }
    
    private void putMap(Map<String, Boolean> map, int nextPhoneLength, String phone) {
        for (int j = 1; j <= nextPhoneLength; j++) {
            String tmpString = phone.substring(0, j);
            if (!map.containsKey(tmpString)) {
                map.put(tmpString, null);
            }
        }
    }
}