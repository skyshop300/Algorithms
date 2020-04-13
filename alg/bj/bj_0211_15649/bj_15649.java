// 백준 15649 : N과 M (1)
// https://www.acmicpc.net/problem/15649
package alg.bj.bj_0211_15649;
import java.util.*;

// DFS
public class bj_15649 {
	static int n, m;
	static boolean[] visit;
	static int[] temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n+1];
		temp = new int[m+1];
		dfs(0, 0);
	}

	public static void dfs(int start, int depth) {
		if (depth >= m) {
			for(int i = 1; i < m + 1; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			visit[start] = false;
			return;
		}

		for(int i = 1; i < n + 1; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp[depth + 1] = i;
				dfs(i, depth + 1);	
				visit[i] = false;	
			}
		}
	}
}