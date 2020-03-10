package alg.programmars.pr_0310_49189;
import java.util.*;

public class pr_49189 {
	public static void main(String[] args) {
		// String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		Solution sol = new Solution();
		System.out.println(sol.solution(clothes));
	}
}

class Solution {
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		int sum = 0;
		int mul = 1;

		for(int i = 0; i < clothes.length; i++) { 
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		for(int value : map.values()) {
			System.out.println("value:" + value);
			sum += value;
			mul *= value;
		}
		int answer = sum + mul;

		return answer;
	}

}