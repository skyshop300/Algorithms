package alg.bj.bfs_0409_13913_test;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Integer> q = new LinkedList<>();
	static int cN;
	static int[] befNs = new int[100001];
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		bfs(N, K);
	}
	
	public static void bfs(int N, int K) {
		cN = N;
		int cQSize = 1;
		int sec = 0;
		q.add(N);

		while (cN != K) {
			next(cN + 1);
			next(cN - 1);
			next(cN * 2);
			if (cQSize == 0) {
				cQSize = q.size();
				sec++;
			}
			cN = q.poll();
			cQSize--;
		}
		
		int route[] = new int[sec + 1];
		route[sec] = cN;

		for (int i = sec - 1; i >= 0; i--) {
			route[i] = befNs[cN];
			cN = route[i];
		}
		
		System.out.println(sec);
		for (int i : route) {
			System.out.print(i + " ");
		}
	}

	public static void next(int nN) {
		if (0 <= nN && nN <= 100000 && !visit[nN]) {
			visit[nN] = true;
			befNs[nN] = cN;
			q.add(nN);
		}
	}
}