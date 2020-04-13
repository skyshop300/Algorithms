package alg.bj.graph_0210_4963;
import java.util.*;

public class graph_0210_4963 {
	static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			int islandNum = 0;
			boolean[][] visit = new boolean[h+1][w+1];
			int[][] map = new int[h+1][w+1];
			if(w == 0 || h == 0) {
				break;
			}
			for(int i = 1; i < h + 1; i++) {
				for(int j = 1; j < w + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i = 1; i < h + 1; i++) {
				for(int j = 1; j < w + 1; j++) {
					if(visit[i][j] == false && map[i][j] == 1) {
						islandNum++;
						visit = bfs(visit, map, j, i);
					}
				}
			}
			System.out.println(islandNum);
		} 
	}
	public static boolean[][] bfs(boolean[][] visit, int[][] map, int startX, int startY) {
		Queue<DOT> q = new LinkedList<>();

		q.add(new DOT(startX, startY));

		while(!q.isEmpty()) {
			DOT dot = q.poll();
			int x = dot.x;
			int y = dot.y;
			for(int i = 0; i < 8; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(ny > 0 && nx > 0 
					&& ny < map.length && nx < map[0].length
					&& map[ny][nx] == 1 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new DOT(nx, ny));
				}
			}
		}
		return visit;
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