// 프로그래머스 - 스택/큐 - 탑
package alg.programmers.pr_0326_42588;
import java.util.*;

public class pr_0326_42588 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] heights;
	}

}

class Solution {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		for (int i = (heights.length - 1); i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				} else {
					answer[i] = 0;
				}
			}
		}
		return answer;
	}
}