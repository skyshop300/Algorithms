package alg.BFSnDFS;
import java.util.*;

public class graph_03_11724 {
	static int n;
	static int m;
	static ArrayList<Integer>[] list;	// 인접 리스트
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 정점의 개수
		m = sc.nextInt();		// 간선의 개수
		
		// list 초기화
		list = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		// 간선 관계 입력
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		sc.close();
		
		// 순서정렬
		for(int i = 1; i < n + 1; i++) {
			Collections.sort(list[i]);
		}

		// 방문 check list 초기화
		check = new boolean[n + 1];

		int answer = 0;
		for(int i = 1; i < n + 1; i++) {
			if(!check[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int x) {
		if(check[x]) {
			return;
		}

		check[x] = true;
		
		for(int y : list[x]) {
			dfs(y);
		}
	}
}