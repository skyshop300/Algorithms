// 백준7576: 그래프 - 토마토
package alg.bj;
import java.util.*;
public class graph_08_7576 {
	public static final int[] dx = {0, 1, 0, -1};
	public static final int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();	// 상자의 가로 칸 수 
		int n = sc.nextInt();	// 상자의 세로 칸 수
		Queue<Dot_7576> queue = new LinkedList<Dot_7576>();
		int map[][] = new int[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					queue.add(new Dot_7576(i, j));
				}
			}
		}
		// BFS 
		int day = bfs(map, queue);
		System.out.println(day);
		sc.close();
	}
	public static int bfs(int[][] map, Queue<Dot_7576> queue) {
		int day = -1;
		int oneDayTomatoNum = 0;
		while(!queue.isEmpty()) {
			if(oneDayTomatoNum == 0) {
				oneDayTomatoNum = queue.size();
				day++;
			}
			Dot_7576 dot = queue.poll();
			int x = dot.x;		// 가장 먼저 보관한 값 꺼내기.
			int y = dot.y;

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length
						&& map[nx][ny] == 0) {
					map[nx][ny] = 1;
					queue.add(new Dot_7576(nx, ny));
				}
			}
			oneDayTomatoNum--;
		}
		if(!checkTomato(map)) {
			return -1;
		}
		return day;
	}

	public static boolean checkTomato(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0) {		// 안 익은 토마토가 있다.
					// TEST
					return false;
				}
			}
		}
		return true;
	}
}

class Dot_7576 {
	int x;
	int y;
	public Dot_7576(int x, int y) {
		this.x = x;
		this.y = y;
	}
}