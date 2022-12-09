class Solution {

    public int solution(int number, int limit, int power) {
        int numberOfIronNeeded = 0;
        
        for (int i = 1; i <= number; i++) {
            numberOfIronNeeded += getNumberOfIronNeeded(limit, power, i);
        }
        
        return numberOfIronNeeded;
    }

    private int getNumberOfIronNeeded(int limit, int power, int i) {
        int numberOfDivisors = getNumberOfDivisors(i);

        if (limit < numberOfDivisors) {
            return power;
        }
        else {
            return numberOfDivisors;
        }
    }

    private int getNumberOfDivisors(int nowNumber) {
        int result = 0;
        for (int i = 1; i * i <= nowNumber; i++) {
            if (nowNumber % i == 0) result++;
            if (nowNumber % i == 0 && i * i < nowNumber) result++;
        }
        
        return result;
    }
}   