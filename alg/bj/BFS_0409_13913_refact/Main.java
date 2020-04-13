package alg.bj.BFS_0409_13913_refact;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Solution sol = new Solution();
		sol.bfs(N, K);
	}
}

class Solution {
	public void bfs(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		int[] beforeNs = new int[100001];
		boolean[] visit = new boolean[100001];
		int currN = N;
		int currQSize = 1;
		int second = 0;
		q.add(N);

		while (currN != K) {
			next(currN + 1, visit, beforeNs, currN, q);
			next(currN - 1, visit, beforeNs, currN, q);
			next(currN * 2, visit, beforeNs, currN, q);
			if (currQSize == 0) {
				currQSize = q.size();
				second++;
			}
			currN = q.poll();
			currQSize--;
		}
		System.out.println(second);
		int route[] = new int[second + 1];
		route[second] = currN;
		for (int i = second - 1; i >= 0; i--) {
			route[i] = beforeNs[currN];
			currN = route[i];
		}

		for (int i : route) {
			System.out.print(i + " ");
		}
	}

	public void next(int nextN, boolean[] visit, int[] beforeNs, int currN, Queue<Integer> q) {
		if (0 <= nextN && nextN <= 100000 && !visit[nextN]) {
			visit[nextN] = true;
			beforeNs[nextN] = currN;
			q.add(nextN);
		}
	}
}
