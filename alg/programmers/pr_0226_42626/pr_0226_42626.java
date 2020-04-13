// 프로그래머스 42626 - 더 맵게\
// priority Queue로 해결해보자  
package alg.programmers.pr_0226_42626;

import java.util.PriorityQueue;

public class pr_0226_42626 {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 15;

		Solution sol = new Solution();
		System.out.println(sol.solution(scoville, K));
		
	}
}

class Solution {
    public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;

		for(int oneScoville : scoville) {
			pq.offer(oneScoville);
		}

		while(pq.peek() <= K) {
			if(pq.size() == 1) {
				return -1;
			}
			int a = pq.poll();
			int b = pq.poll();

			int sum = a + (b * 2);
			pq.offer(sum);
			answer++;
		}
		return answer;
    }
}