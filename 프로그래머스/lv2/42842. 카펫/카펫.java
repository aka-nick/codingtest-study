class Solution {
    public int[] solution(int brown, int yellow) {

        int horizontalOfYellow = yellow;
        int verticalOfYellow = 1;

        while (verticalOfYellow <= horizontalOfYellow) {
            if (isMatched(brown, yellow, horizontalOfYellow, verticalOfYellow)) break;

            horizontalOfYellow = yellow / (++verticalOfYellow);
        }

        return new int[]{horizontalOfYellow + 2, verticalOfYellow + 2};
    }

    private boolean isMatched(int brown, int yellow, int horizontalOfYellow, int verticalOfYellow) {
        return (horizontalOfYellow * 2) + (verticalOfYellow * 2) + 4 == brown && 
                horizontalOfYellow * verticalOfYellow == yellow;
    }
}