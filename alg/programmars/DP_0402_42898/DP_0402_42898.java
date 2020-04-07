// DP - 등굣길 - 42898
package alg.programmars.DP_0402_42898;
public class DP_0402_42898 {
	// puddle이 존재하면 해당 공간을 0으로 설정.
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 4;					// 격자 가로
		int n = 3;					// 격자 세로
		int[][] puddles = {{2,2}};	// 웅덩이 0 <= p <= 10
		System.out.println(sol.solution(m, n, puddles));
	}
}

class Solution {
	public int solution(int m, int n, int[][] puddles) {
		int[][] caseMap = new int[m + 1][n + 1];
		boolean[][] puddlesMap = new boolean[m + 1][n + 1];
		int answer = 0;
		caseMap[1][1] = 1;

		puddlesMap[1][1] = true;
		for(int i = 0; i < puddles.length; i++) {
			puddlesMap[puddles[i][0]][puddles[i][1]] = true;
		}

		for(int i = 1; i < m + 1; i++) {
			for(int j = 1; j < n + 1 ; j++) {
				if(!puddlesMap[i][j]) {
					caseMap[i][j] = caseMap[i-1][j] +  caseMap[i][j-1] % 1000000007;
				}
			}
		}
		answer = caseMap[m][n];
		return answer;
	}
}