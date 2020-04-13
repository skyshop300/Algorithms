package alg.programmers.pr_0227_42748;
import java.util.*;
public class pr_0227_42748 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		Solution sol = new Solution();
		System.out.println(sol.solution(array, commands));
	}
}

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int finish = commands[i][1];
			int num = commands[i][2];
			int[] smallArray = new int[finish - start + 1];

			for(int j = 0 ; j < finish - start + 1; j++) {
				smallArray[j] = array[j + start - 1];
			}

			Arrays.sort(smallArray);
			answer[i] = smallArray[num - 1];
		}
        return answer;
	}
}