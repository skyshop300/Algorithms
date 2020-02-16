package alg.bj_0216_2206_제출;
import java.util.*;

// 최단거리 - BFS
// 벽을 한개 까지 부술 수 있다.	// Queue를 2개 둬야.
// 상하좌우 이동
// BFS는 while 문이다.
public class bj_0216_2206 {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][m+1];
		int[][] visit = new int[n+1][m+1];
		for(int i = 1; i < n + 1; i++) {
			String str = sc.next();
			for(int j = 0; j < m; j++) {
				map[i][j+1] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs(map, visit, n, m));
	}

	public static int bfs(int[][] map, int[][] visit, int n, int m) {
		Queue<DOT> q1 = new LinkedList<>();	// 벽을 뚫지 않는 경우
		Queue<DOT> q2 = new LinkedList<>();	// 벽을 뚫을 경우
		q1.add(new DOT(1, 1));
		visit[1][1] = 1;
		boolean isBreak = false;
		int nx = 0;
		int ny = 0;
		int x = 0;
		int y = 0;
		while(!(q1.isEmpty() && q2.isEmpty())) {
			if(q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<>();
				isBreak = true;
			}

			DOT cuurQ = q1.poll();
			x = cuurQ.x;
			y = cuurQ.y;

			for(int i = 0 ; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx > 0 && ny > 0 && nx < m + 1 && ny < n + 1 
					&& (visit[ny][nx] == 0 || (map[ny][nx] != 1 && isBreak && visit[ny][nx] > visit[y][x] + 1))) {		// next
					if(map[ny][nx] == 0) {						// 장애물이 없는 경우
						q1.add(new DOT(nx, ny));
					} else if(!isBreak && map[ny][nx] == 1) {	// 장애물이 존재
						q2.add(new DOT(nx, ny));
					}
					visit[ny][nx] = visit[y][x] + 1;
				}
			}
		}
		if(visit[n][m] == 0) {
			visit[n][m] = -1;
		}
		return visit[n][m];
	}
}

class DOT{
	int x; 
	int y;
	public DOT(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/* 
6 4
0000
1110
1000
0000
0111
0000
 */