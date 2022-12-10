import java.util.*;

class Solution {

    private static final Character RT_R = 'R';
    private static final Character RT_T = 'T';
    private static final Character CF_C = 'C';
    private static final Character CF_F = 'F';
    private static final Character JM_J = 'J';
    private static final Character JM_M = 'M';
    private static final Character AN_A = 'A';
    private static final Character AN_N = 'N';

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        initScoreMap(scoreMap);

        for (int i = 0; i < survey.length; i++) {
            calculateScore(survey, choices, scoreMap, i);
        }

        StringBuilder result = new StringBuilder();
        result.append(getHighScoreChar(RT_R, RT_T, scoreMap));
        result.append(getHighScoreChar(CF_C, CF_F, scoreMap));
        result.append(getHighScoreChar(JM_J, JM_M, scoreMap));
        result.append(getHighScoreChar(AN_A, AN_N, scoreMap));
        return result.toString();
    }

    private void calculateScore(
            String[] survey,
            int[] choices,
            Map<Character, Integer> scoreMap,
            int i) {

        int nowChoice = choices[i] - 4;
        String nowString = survey[i];

        char disagreeOption = nowString.charAt(0);
        char agreeOption = nowString.charAt(1);

        if (0 < nowChoice) {
            applyScore(scoreMap, agreeOption, nowChoice);
        }
        else {
            applyScore(scoreMap, disagreeOption, -nowChoice);
        }
    }

    private void applyScore(Map<Character, Integer> scoreMap, char agreeOption, int nowScore) {
        scoreMap.put(agreeOption, scoreMap.get(agreeOption) + nowScore);
    }

    private void initScoreMap(Map<Character, Integer> scoreMap) {
        scoreMap.put(RT_R, 0);
        scoreMap.put(RT_T, 0);
        scoreMap.put(CF_C, 0);
        scoreMap.put(CF_F, 0);
        scoreMap.put(JM_J, 0);
        scoreMap.put(JM_M, 0);
        scoreMap.put(AN_A, 0);
        scoreMap.put(AN_N, 0);
    }

    private char getHighScoreChar(char firstChar, char secondChar, Map<Character, Integer> scoreMap) {
        if (scoreMap.get(secondChar) <= scoreMap.get(firstChar)) {
            return firstChar;
        }
        else {
            return secondChar;
        }
    }
}