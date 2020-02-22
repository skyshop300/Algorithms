package alg.programmars;
import java.util.*;

public class pr_43165 {
	public static void main(String[] args) {
		int[] numbers = {1,1,2};
		int target = 4;
		Solution sol = new Solution();
		System.out.println(sol.solution(numbers, target));
	}
}

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new LinkedList<Integer>();
		int numbesLength = numbers.length;
        int answer = 0;

        int depth = 0;
        int currQueueSize = 0;
        int currQ = 0;

        while(true) {
            q.add(currQ + numbers[depth]);
            q.add(currQ - numbers[depth]);

            if(currQueueSize == 0) {
                currQueueSize = q.size();
                depth++;
                if(depth == numbesLength) {
                    break;
                }
            }
			currQ = q.poll();
			
            currQueueSize--;
        }

		while(!q.isEmpty()) {
			int result = q.poll();
            if(result == target) {
				answer++;
            }
        }
        return answer;
	}
}