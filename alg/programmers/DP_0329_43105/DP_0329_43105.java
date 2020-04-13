package alg.programmers.DP_0329_43105;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DP_0329_43105 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(sol.solution(triangle));
	}

}

class Solution {
	public int solution(int[][] triangle) {
		int answer = 0;
		int triLen = triangle.length;

		List<Integer> r1 = new ArrayList<>();
		List<Integer> r2 = new ArrayList<>();

		r1.add(triangle[0][0]);

		for(int i = 1; i < triLen; i++) {
			r2 = new ArrayList<>();
			for(int j : r1) {
				r2.add(j);
			}
			r1 = new ArrayList<>();
			r1.add(r2.get(0) + triangle[i][0]);

			for(int j = 1; j < i; j++) {
				int currNum = triangle[i][j];
				int num1 = r2.get(j);	//triangle[i][j];
				int num2 = r2.get(j-1);	//triangle[i][j+1];
				int num3 = ((num1 > num2) ? num1 : num2) + currNum;
				r1.add(num3);
			}
			r1.add(r2.get(i-1) + triangle[i][i]);
		}
		answer = Collections.max(r1);
		return answer;
	}
}
