package alg.programmers.pr_0308_43237_BK;
import java.util.*;

public class pr_43237 {
	public static void main(String[] args) {
		int[] budgets = {1, 100, 105, 55, 42, 41, 44};
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

		Arrays.sort(budgets);
		int maxBudget = budgets[budgets.length - 1];
		answer = (int)((M - tempBudget) / (budgets.length - availableBudgetNum));

		if (availableBudgetNum == budgets.length) {
			Arrays.sort(budgets);
			answer = budgets[budgets.length - 1];
			return answer;
		}
		if (maxBudget < answer) {
			answer = maxBudget;
			return answer;
		}


		return answer;
    }
}