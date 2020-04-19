package alg.bj.DP_0416_1890;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();					// 2^63
		int map[][] = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		DOT dot = new DOT(1, 1);
		Solution sol = new Solution();
		System.out.println(sol.solution(N,dot,map));
	}
}

class Solution {
	public int solution( int N, DOT dot, int[][] map) {
		int num = 0;
		int jump = map[dot.x][dot.y];

		if(dot.x == N && dot.y == N) {
			return 1;
		}
		if(jump == 0) {
			return 0;
		}

		// 오른쪽
		if(dot.x + jump <= N) {
			num += solution(N, new DOT(dot.y, dot.x + jump ), map);
		}

		// 아래쪽
		if(dot.y + jump <= N) {
			num += solution(N, new DOT(dot.y + jump, dot.x), map);
		}
		return num;
	}
}

class DOT {
	int x;
	int y;
	public DOT(int x, int y) {
		this.x = x; 
		this.y = y;
	}
}