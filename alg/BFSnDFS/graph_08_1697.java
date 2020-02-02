// 백준1697: 그래프 - 숨바꼭질
package alg.BFSnDFS;
import java.util.*;
public class graph_08_1697 {
	public static final int MAX = 100001;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int answer = bfs(n, k);
		System.out.println(answer);
		sc.close();
	}
	
	public static int bfs(int n, int k) {
		if(n == k) {
			return 0;
		}
		int currentDepthSize = 0;
		int answer = 0;
		boolean[] visit = new boolean[MAX];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while(!q.isEmpty()) {
			if(currentDepthSize == 0) {
				answer++;
				currentDepthSize = q.size();
			}
			currentDepthSize--;

			int x = q.poll();
			
			int nextX = x - 1;
			if(nextX > -1 && !visit[nextX]) {
				visit[nextX] = true;
				if(nextX == k) {
					break;
				}
				q.add(nextX);
			}
			
			nextX = x + 1;
			if(nextX < MAX && !visit[nextX]) {
				visit[nextX] = true;
				if(nextX == k) {
					break;
				}
				q.add(nextX);
			}

			nextX = x * 2;
			if(nextX < MAX && !visit[nextX]) {
				visit[nextX] = true;
				if(nextX == k) {
					break;
				}
				q.add(nextX);
			}
		}
		return answer;
	}
}