package alg.Codility_practice;
public class training01 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int N = 5;
		System.out.println(sol.solution(N));
	}
}
class Solution {
    public int solution(int N) {
		int maxGap = 0;
		int currGap = 0;

		while (N != 1) {
			if (N % 2 == 1) {
				if (maxGap < currGap) {
					maxGap = currGap;
				}
				currGap = 0;
			} else {
				currGap++;
			}
			N /= 2;
		}
		if (maxGap < currGap && maxGap != 0) {
			maxGap = currGap;
		}
		return maxGap;
    }
}