package alg.programmers.DP_0329_43104;
public class DP_0329_43104 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(6));
	}
}

class Solution {
    public long solution(int N) {
        long answer = 0;
		long[] answers = new long[N + 1];
		answers[1] = 1;
		answers[2] = 1;
		for(int i = 3; i < N + 1; i++) {
			answers[i] = answers[i - 1] + answers[i - 2];
		}
		answer = answers[N] * 4 + answers[N-1] * 2;
        return answer;
    }
}