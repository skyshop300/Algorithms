package alg.BFSnDFS;
import java.util.*;

// 5개의 깊이까지 들어가는 경우의수가 있는가?
// DFS로 해결해보자
public class graph_01_13024 {
	static boolean[] visited;
	static ArrayList<Integer>[] list;	// 인접리스트
	static int currentDepth;
	static int startVertex;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 정점의 개수
		int m = sc.nextInt();		// 간선의 개수
		// int start = sc.nextInt();	// 탐색 시작의 정점 번호
		visited = new boolean[n];

		// 인접리스트 초기화
		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++) {
			// 두 간선을 연결하는 두 정점의 번호
			int u = sc.nextInt();	
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}

		// 순서 정렬 // 반드시 필요 // 반례 참고
		for (int i = 0; i < n; i++) {
			Collections.sort(list[i]);
		}

		for(int i = 0; i < n; i++) {
			startVertex = i;
			if(dfs(i)) {
				System.out.println(1);
				return;
			}
			currentDepth = 0;
			visited = new boolean[n];
		}
		System.out.println(0);
	}

	// DFS 인접리스트
	public static boolean dfs(int x) {
		currentDepth++;

		visited[x] = true;
		// 반례2
		if(currentDepth > 3) {
			// 초기값 열어주기
			visited[startVertex] = false;
		}
		
		if(currentDepth >= 5) {
			return true;
		}

		for(int y : list[x]) {
			if(!visited[y]) {
				if(dfs(y)) {
					return true;
				}
			} 
		}
		currentDepth--;
		return false;
	}
}

// 반례1: 트리로서의 DFS와 다르게 시작점을 비방문으로 표시해줘야한다.
// 5 5
// 0 1
// 1 3
// 1 2
// 2 3
// 3 4
// 1

// 반례2: static 변수와 for문 그리고 초기화 // 여러번 시도할 때에 visited list의 초기화
// 5 4
// 3 0
// 0 1
// 1 4
// 4 2
// 1