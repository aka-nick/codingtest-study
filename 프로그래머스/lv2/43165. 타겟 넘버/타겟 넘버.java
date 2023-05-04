class Solution {

    int[] numbers;
    int target;
    int result;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.result = 0;

        bt(0, 0);

        return result;
    }

    void bt(int depth, int value) {
        if (depth == numbers.length) {
            if (value == target) result++;
            return;
        }

        bt(depth + 1, value + numbers[depth]);
        bt(depth + 1, value - numbers[depth]);
    }

}