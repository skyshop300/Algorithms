// 백준1463: 1로 만들기 - BFS 이용
package alg.DP;
import java.util.*;

public class BFS_01_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int minCalc = bfs(n);
		System.out.println(minCalc);
	}

	public static int bfs(int n) {
		if(n == 1) {
			return 0;
		}
		int minCalc = 0;
		int nextN = 0;
		int currentDepth = 0;
		Queue<Integer> q = new LinkedList<>();

		q.add(n);

		while(!q.isEmpty()) {
			if(currentDepth == 0) {
				currentDepth = q.size();
				minCalc++;
			}
			n = q.poll();
			currentDepth--;

			if(n % 3 == 0) {
				nextN = n / 3;
				q.add(nextN);
				if(nextN == 1) {
					break;
				}
			}
			if(n % 2 == 0) {
				nextN = n / 2;
				q.add(nextN);
				if (nextN == 1) {
					break;
				}
			}
			
			nextN = n - 1;
			q.add(nextN);
			if (nextN == 1) {
				break;
			}
		}
		
		return minCalc;
	}
}