package alg.bj;
import java.util.*;

public class graph_02_1260_matrix {
	static int[][] map;
	static boolean[] check;	
	static int n;			

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 정점의 갯수
		int m = sc.nextInt();		// 간선의 갯수
		int start = sc.nextInt();	//	탐색 시작의 정점 번호
		
		map = new int[n + 1][n + 1];
		check = new boolean[n + 1];

		int u, v; // 두 간선을 연결하는 두 정점의 번호

		for (int i = 1; i <= m; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			map[u][v] = 1; // 두 정점간의 연결 관계를 1로 표시
			map[v][u] = 1;
		}

		dfs_stack(start);
		resetVisited();
		bfs(start);
		sc.close();
	}

	public static void resetVisited() {
		for (int i = 1; i < n + 1; i++) {
			check[i] = false;
		}
		System.out.println();
	}

	// 깊이 우선 탐색 (Depth First Search) // 재귀함수
	private static void dfs(int x) {
		check[x] = true;
		System.out.print(x + " ");

		for (int i = 1; i < n + 1; i++) {
			if (map[x][i] == 1 && check[x] == false) {
				dfs(i);
			}
		}
	}

	// 깊이 우선 탐색 (Depth First Search) // 스택
	public static void dfs_stack(int x) {
		Stack<Integer> stack = new Stack<>();
		stack.push(x);
		int currentX; // 탐색중인 정점
		boolean haveAdjacentX; //

		check[x] = true; // 방문한 정점 체크.

		System.out.print(x + " ");

		while (!stack.isEmpty()) {
			currentX = stack.peek();
			haveAdjacentX = false;

			for (int i = 1; i < n + 1; i++) {
				if (map[currentX][i] == 1 && !check[i]) { // 간선으로 연결되어있으며 아직 방문하지 않은 정점
					stack.push(i);
					check[i] = true;
					System.out.print(i + " ");
					haveAdjacentX = true;
					break;
				}
			}

			// 반복문에서 조건에 충족하지 않았을 경우 해당 정점 제거.
			if (!haveAdjacentX) {
				stack.pop();
			}
		}
	}

	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(x);
		check[x] = true; // 방문한 정점 체크.

		while (!queue.isEmpty()) {
			x = queue.poll(); // 가장 먼저 보관한 값 꺼내기
			System.out.print(x + " ");

			for (int i = 1; i < n + 1; i++) { // 주변 정점 모두 확인
				if (map[x][i] == 1 && !check[i]) {
					queue.offer(i); // 보관
					check[i] = true;
				}
			}
		}
	}
}