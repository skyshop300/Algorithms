package alg.BFSnDFS;
import java.util.*;

public class graph_04_1707 {
	static int[] state;	// 0: 미방문 // 1: 상태1, 2: 상태2
	static ArrayList<Integer>[] list;
	static int depth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		boolean[] isSuccess = new boolean[testCase];

		for(int i = 0; i < testCase; i++) {
			isSuccess[i] = true;
			int v = sc.nextInt();
			int e = sc.nextInt();

			list = new ArrayList[v + 1];
			for(int j = 0; j < v + 1; j++) {
				list[j] = new ArrayList<Integer>();
			}

			for(int j = 0; j < e; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[a].add(b);
				list[b].add(a);
			}

			state = new int[v + 1];
			for(int j = 1; j < v + 1; j++) {
				if(state[j] == 0) {
					state[j] = 1;
					if (!dfs(j)) {
						isSuccess[i] = false;
						break;
					} 
				}
			}
		}
		for(int i = 0; i < testCase; i++) {
			if(isSuccess[i]) {
				 System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

	public static boolean dfs(int x) {
		depth++;
		for(int y : list[x]) {
			if(state[y] == 0) {
				if(state[x] == 1){
					state[y] = 2;
				} else {
					state[y] = 1;
				}
				if(!dfs(y)) {
					return false;
				}
			} else if(state[y] == state[x]) {
				return false;
			}
		}
		return true;
	}
}
