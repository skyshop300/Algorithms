package alg.BFSnDFS.graph_0211_1261_algospot;
import java.util.*;

public class graph_0211_1261_algospot {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		// 2개의 Queue를 이용하여 풀어야하는 문제같다
		// 2개의 Queue를 이용할 경우 최단 거리를 map에 따로 저장해야한다
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();	// 가로 X
		int n = sc.nextInt();	// 세로 Y
		int[][] map = new int[n+1][m+1];
		boolean[][] visit = new boolean[n+1][m+1];
		

		for(int i = 1; i < n+1; i++) {	
			String str = sc.next();
			for(int j = 1; j < m+1; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		int minDestroy = bfs(map, visit, n, m);
		System.out.println(minDestroy);
	}

	public static int bfs(int[][] map, boolean[][] visit, int n, int m) {
		Queue<DOT> q1 = new LinkedList<>();
		Queue<DOT> q2 = new LinkedList<>();
		int[][] destroyNum = new int[n+1][m+1];
		q1.add(new DOT(1, 1));
		visit[1][1] = true;
		
		while (!(q1.isEmpty() && q2.isEmpty())) {
			if(q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<>();
			}
			DOT currDot = q1.poll();
			int currX = currDot.x;
			int currY = currDot.y;
			System.out.println("currX:" + currX);
			System.out.println("currY:" + currY);
			if(m == currX && n == currY) {
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextX = currX + dx[i];
				int nextY = currY + dy[i];
				if(nextX > 0 && nextY > 0 && nextX < m + 1 && nextY < n + 1
					&& !visit[nextY][nextX] ) {
					System.out.println(map[nextY][nextX]);
					System.out.println("NEXT: map[" + nextY + "][" + nextX + "]" + map[nextY][nextX]);
					if(map[nextY][nextX] == 0) {
						q1.add(new DOT(nextX, nextY));
						System.out.println("q1에 저장");
						destroyNum[nextY][nextX] = destroyNum[currY][currX] ;
					} else {
						q2.add(new DOT(nextX, nextY));
						map[nextY][nextX] = 0;
						System.out.println("q2에 저장");
						System.out.println("CURR: destroyNum[" + currY + "][" + currX + "]" + destroyNum[currY][currX]);
						destroyNum[nextY][nextX] = destroyNum[currY][currX] + 1;
						System.out.println("NEXT: destroyNum[" + nextY +"]["+ nextX +"]" + destroyNum[nextY][nextX]);
					}
					visit[nextY][nextX] = true;
				}
			}
		}
		return destroyNum[n][m];
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