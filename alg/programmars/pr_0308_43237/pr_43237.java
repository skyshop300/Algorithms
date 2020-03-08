package alg.programmars.pr_0308_43237;
import java.util.*;

public class pr_43237 {
	public static void main(String[] args) {
		int[] budgets = {0, 42, 43, 42, 42, 41, 44};
		int M = 300;
		Solution sol = new Solution();
		System.out.println(sol.solution(budgets, M));
	}
}

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
		int avgM = M / budgets.length;
		long tempBudget = 0;
		int availableBudgetNum = 0;

		for (int budget : budgets) {
			if (avgM >= budget) {
				tempBudget += budget;
				availableBudgetNum++;
			}
		}

		// 369 11

		// Arrays.sort(budgets);
		// int maxBudget = budgets[budgets.length - 1];

		if (availableBudgetNum == budgets.length) {
			Arrays.sort(budgets);
			answer = budgets[budgets.length - 1];
			return answer;
		}

		// answer = (int)((M - tempBudget) / (budgets.length - availableBudgetNum));

		return answer;
    }
}