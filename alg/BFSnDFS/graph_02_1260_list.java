package alg.BFSnDFS;
import java.util.*;

public class graph_02_1260_list {
	static ArrayList<Integer>[] list;	//인접리스트
	static boolean[] check;				

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 정점의 갯수
		int m = sc.nextInt();		// 간선의 갯수
		int start = sc.nextInt();	//	탐색 시작의 정점 번호

		list = new ArrayList[n+1];

		for(int i = 1; i < n + 1; i++ ) {
			list[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++) {
			int u = sc.nextInt();		// 두 간선을 연결하는 두 정점의 번호
			int v = sc.nextInt();		// 두 간선을 연결하는 두 정점의 번호
			list[u].add(v);
			list[v].add(u);
		}

		// 순서 정렬
		for(int i = 1; i < n + 1; i++) {
			Collections.sort(list[i]);
		}
		
		check = new boolean[n + 1];
		dfsList(start);
		System.out.println();

		check = new boolean[n + 1];
		bfsList(start);
		System.out.println();

		sc.close();
	}

	// DFS 인접리스트
	public static void dfsList(int x) {
		if(check[x]) {
			return;
		}
		check[x] = true;
		System.out.print(x + " ");
		for(int y : list[x]) {
			if(!check[y]) {
				dfsList(y);
			}
		}
	}

	// BFS 인접리스트
	public static void bfsList(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for(int y: list[x]){
				if(!check[y]){
					check[y] = true;
					queue.add(y);
				}
			}
		}
	}
}