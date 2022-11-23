import java.util.*;

class Solution {

    public int solution(int[] ingredient) {

        int numberOfBurgers = 0;
        List<Integer> ingres = new ArrayList<>();

        for (int i = 0; i < ingredient.length; i++) {
            int nowIngre = ingredient[i];
            ingres.add(nowIngre);

            if (ingres.size() < 4) continue;
            if (!isBread(nowIngre)) continue;

            if (isCompleted(ingres)) numberOfBurgers++;
        }

        return numberOfBurgers;
    }
    
    private boolean isBread(int ingre) {
        return ingre == 1;
    }
    
    private boolean isCompleted(List<Integer> ingres) { // 1 2 3 1
        int lastIndex = ingres.size() - 1;

        int ingre4 = ingres.get(lastIndex);
        if (ingre4 != 1) return false;

        int ingre3 = ingres.get(lastIndex - 1);
        if (ingre3 != 3) return false;

        int ingre2 = ingres.get(lastIndex - 2);
        if (ingre2 != 2) return false;

        int ingre1 = ingres.get(lastIndex - 3);
        if (ingre1 != 1) return false;

        exportFinishedBurger(ingres);

        return true;
    }
    
    private void exportFinishedBurger(List<Integer> ingres) {
        int lastIndex = ingres.size() - 1;
        for (int i = lastIndex; lastIndex - 4 < i; i--) {
            ingres.remove(i);
        }
    }
}