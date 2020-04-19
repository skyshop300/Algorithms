package alg.bj.DP_0416_1890_2;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();					// 2^63
		int map[][] = new int[N + 1][N + 1];
		long caseMap[][] = new long[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		caseMap[1][1] = 1;
		Solution sol = new Solution();
		sol.solution(N, map, caseMap);
		System.out.println(caseMap[N][N]);
	}
}

class Solution {
	public void solution(int N, int[][] map, long[][] caseMap) {
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = i; j < N + 1; j++) {

				// 가로축 계산
				int jump = map[i][j];
				long currCase = caseMap[i][j] ;
				if(!(jump == 0 || currCase == 0)) {
					if (i + jump <= N) {
						caseMap[i + jump][j] += currCase;
					}
					if (j + jump <= N) {
						caseMap[i][j + jump] += currCase;
					}
				}

				// 세로축 계산
				if(j == i) {
					continue;
				}
				jump = map[j][i];
				currCase = caseMap[j][i];
				if (!(jump == 0 || currCase == 0)) {
					if (j + jump <= N) {
						caseMap[j + jump][i] += currCase;
					}
					if (i + jump <= N) {
						caseMap[j][i + jump] += currCase;
					}
				}
			}
		}
	}
}