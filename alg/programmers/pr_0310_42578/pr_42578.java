package alg.programmers.pr_0310_42578;
import java.util.*;

public class pr_42578 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		// String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		Solution sol = new Solution();
		System.out.println(sol.solution(clothes));
	}
}

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		int answer = 1;

		for(int i = 0; i < clothes.length; i++) { 
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		for(int value : map.values()) {
			System.out.println("value: " + value);
			answer *= value+1;
		}

		return answer-1;
	}
}