class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        int[] newElements = new int[length * 3];
        setNewElements(elements, length, newElements);

        int result = 0;
        Integer[] sums = new Integer[1000000];
        // 첫번째(1) 숫자부터, n번째 숫자까지
        // 한개부터~n개까지 더한 숫자를 기록
        // 기록배열을 훑으며 값이 null이 아니면 카운트. 카운트 한 값을 반환.
        for (int countOfSum = 0; countOfSum < length; countOfSum++) {
            for (int start = 0; start < length; start++) {
                int sumOfSubsequence = 0;
                for (int idx = start; idx <= start + countOfSum; idx++) {
                    sumOfSubsequence += newElements[idx + countOfSum];
                }
                if (sums[sumOfSubsequence] == null) {
                    sums[sumOfSubsequence] = 1; //기록
                    result++;
                }
            }
        }

        return result;
    }

    private void setNewElements(int[] elements, int length, int[] newElements) {
        for (int i = 0; i < length; i++) {
            newElements[i] = elements[i];
        }
        for (int i = 0; i < length; i++) {
            newElements[i + length] = elements[i];
        }
        for (int i = 0; i < length; i++) {
            newElements[i + length + length] = elements[i];
        }
    }
}