// 백준2667: 그래프 - 단지번호붙이기
package alg.BFSnDFS;
import java.util.*;

public class graph_05_2667 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> houseNumList = new ArrayList<>();

		int[][] map = new int[n][n];
		boolean[][] visit = new boolean[n][n];

		// INPUT
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int houseNum = 0;
				if(map[i][j] != 0 && !visit[i][j]) {
					houseNum = dfs(map, visit, i, j);
					houseNumList.add(houseNum);
				}
			}	
		}

		System.out.println(houseNumList.size());
		Collections.sort(houseNumList);
		for(int i : houseNumList) {
			System.out.println(i);
		}
	}

	public static int dfs(int[][] map, boolean[][] visit, int i, int j) {
		int houseNum = 1;
		if(map[i][j] == 0 || visit[i][j]) {
			return 0;
		}
		visit[i][j] = true;

		// 상
		if(i > 0) {
			houseNum += dfs(map, visit, i - 1, j);
		}
		// 우
		if(j < map.length - 1) {
			houseNum += dfs(map, visit, i, j + 1);
		}
		// 하
		if(i < map.length - 1) {
			houseNum += dfs(map, visit, i + 1, j);
		}
		// 좌
		if(j > 0) {
			houseNum += dfs(map, visit, i, j - 1);
		}
		return houseNum;
	}
}