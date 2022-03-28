import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
		int[] answer;
		int count1 = 0, count2 = 0, count3 = 0;
		int i1 = 0, i2 = 0, i3 = 0;
		int[] arr1 = {1,2,3,4,5}, arr2 = {2,1,2,3,2,4,2,5}, arr3 = {3,3,1,1,2,2,4,4,5,5};

		for (int a : answers) {
			if (a == arr1[i1]) count1 += 1;
			if (a == arr2[i2]) count2 += 1;
			if (a == arr3[i3]) count3 += 1;

			i1 += 1;
			i2 += 1;
			i3 += 1;

			if (i1 % arr1.length == 0) i1 = 0;
			if (i2 % arr2.length == 0) i2 = 0;
			if (i3 % arr3.length == 0) i3 = 0;
		}

		int max = count1 > count2 ? count1 : (count2 > count3 ? count2 : count3);
		max = Math.max(count1, Math.max(count2, count3));
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		if (max == count1) answerList.add(1);
		if (max == count2) answerList.add(2);
		if (max == count3) answerList.add(3);
		
		answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i += 1) {
			answer[i] = answerList.get(i);
			System.out.println(answerList.get(i));
		}
		
		return answer;
	}
}