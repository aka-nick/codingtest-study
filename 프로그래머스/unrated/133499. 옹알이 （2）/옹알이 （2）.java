class Solution {
    
    private static final char[] AYA = {'a', 'y', 'a'};
    private static final char[] YE = {'y', 'e'};
    private static final char[] WOO = {'w', 'o', 'o'};
    private static final char[] MA = {'m', 'a'};

    public int solution(String[] babbling) {

        int count = 0;

        for (String word : babbling) {
            if (isReadableWord(word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isReadableWord(String word) {

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (is(AYA, chars, i)) {
                if (is(AYA, chars, i + AYA.length)) {
                    return false;
                }
                i += getNextWordIndex(AYA);
            }
            else if (is(YE, chars, i)) {
                if (is(YE, chars, i + YE.length)) {
                    return false;
                }
                i += getNextWordIndex(YE);
            }
            else if (is(WOO, chars, i)) {
                if (is(WOO, chars, i + WOO.length)) {
                    return false;
                }
                i += getNextWordIndex(WOO);
            }
            else if (is(MA, chars, i)) {
                if (is(MA, chars, i + MA.length)) {
                    return false;
                }
                i += getNextWordIndex(MA);
            }
            else {
                return false;
            }
        }

        return true;
    }

    private boolean is(char[] babword, char[] chars, int index) {
        if (chars.length <= index + babword.length - 1) {
            return false;
        }

        for (int i = 0; i < babword.length; i++) {
            if (babword[i] != chars[index + i]) {
                return false;
            }
        }

        return true;
    }

    private int getNextWordIndex(char[] babword) {
        return babword.length - 1;
    }
}