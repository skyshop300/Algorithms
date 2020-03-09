package alg.programmars.pr_0309_43237;
import java.util.*;

public class pr_43237 {
	public static void main(String[] args) {
		int[] budgets = {98,99,100,101,102};
		int M = 500;
		Solution sol = new Solution();
		System.out.println(sol.solution(budgets, M));
	}
}

class Solution {
    public int solution(int[] budgets, int M) {
		Arrays.sort(budgets);

		int min = M / budgets.length;
		int max = budgets[budgets.length - 1];
		int pivot = min;
		boolean isCheck = false;
		
		while(true) {
			long sum = 0;
			for(int budget : budgets) {
				if(budget < pivot) {
					sum += budget;
				} else {
					sum += pivot;
				}
			}
			
			if(sum <= M) {
				min = pivot;
			} else {
				max = pivot;
			}
			pivot = (min + max) / 2;

			if(isCheck) {
				break;
			}

			if(max - min < 2) {
				isCheck = true;
				pivot = max;
			}
		}
		
		int answer = min;
        return answer;
    }
}