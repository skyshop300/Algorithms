// 백준 15650: N과 M(2)
package alg.bj_0212_15650;
import java.util.*;

public class bj_0212_15650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int depth = 0;
		boolean[] visit = new boolean[n+1];
		int[] temp = new int[m+1];

		nm(temp, visit, depth, n, m);
	}

	public static void nm(int[] temp, boolean[] visit, int depth, int n, int m) {
		depth++;
		if (depth == m) {
			for (int i = 1; i < m + 1; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i < n+1; i++) {
			if(!visit[i]) {
				visit[i] = true;
				temp[depth] = i;
				nm(temp, visit, depth, n, m);
			}
			visit[i] = false;
		}

	
	}
}