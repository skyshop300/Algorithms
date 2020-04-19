package alg.programmers.DP_0418_42898;
// 최단경로의 개수를 구해야한다.
public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 4;
		int n = 3; 
		int[][] puddles ={{2,2}};
		System.out.println(sol.solution(m, n, puddles));
	}	
}

class Solution {
	public int solution(int m, int n, int[][] puddles) {
		int map[][] = new int[n+1][m+1];
		int answer = 0;
		int[][] puddlesMap = new int[n + 1][m + 1];
		

		for(int i = 1; i < n + 1; i++) {
			map[i][1] = 1;
		}
		for(int i = 2; i < m + 1; i++) {
			map[1][i] = 1;
		}

		for(int i = 2; i < n + 1; i++) {
			for(int j = 2; j < m + 1; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		return map[n][m];
	}
}