package alg.BFSnDFS;
import java.util.*;

public class graph_11_13549 {
	static final int MAX = 100000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int k = sc.nextInt();

		int answer = bfs(n, k);
		System.out.println(answer);
	}
	public static int bfs(int n, int k) {
		if(n == k) {
			return 0; 
		}
		int answer = 0;
		int nextN = 0;
		boolean visit[] = new boolean[MAX + 1];
		int second[] = new int[MAX + 1];
		// 현재큐
		Queue<Integer> currQ = new LinkedList<Integer>();
		// 다음큐
		Queue<Integer> nextQ = new LinkedList<Integer>();

		currQ.add(n);
		visit[n] = true;
		second[n] = 0;

		while(!(currQ.isEmpty() && nextQ.isEmpty())) {

			if(currQ.isEmpty()) {
				currQ = nextQ;
				nextQ = new LinkedList<Integer>();
			}
			n = currQ.poll();

			nextN = 2 * n;
			if(nextN == k) {
				answer = second[n];
				break;
			}
			if(nextN <= MAX && !visit[nextN]) {
				currQ.add(nextN);
				second[nextN] = second[n];
				visit[nextN] = true;
			}

			nextN = n + 1;
			if(nextN == k) {
				answer = second[n] + 1;
				break;
			}
			if(nextN <= MAX && !visit[nextN]) {
				nextQ.add(nextN);
				visit[nextN] = true;
				second[nextN] = second[n] + 1;
			}

			nextN = n - 1;
			if(nextN == k) {
				answer = second[n] + 1;
				break;
			}
			if(nextN >= 0 && !visit[nextN]) {
				nextQ.add(nextN);
				visit[nextN] = true;
				second[nextN] = second[n] + 1;
			}
		}
		return answer;
	}
}