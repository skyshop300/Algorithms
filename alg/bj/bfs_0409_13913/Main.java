// 백준 bfsdfs 숨바꼭질4
// https://www.acmicpc.net/problem/13913
package alg.bj.bfs_0409_13913;
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
		// bfs(N, K);
	}
	// public static void bfs(int N, int K) {
	// 	Queue<Integer> q = new LinkedList<>();
	// 	int[] beforeNs = new int[100001];	// 예전 수를 저장해볼까?
	// 	boolean[] visit = new boolean[100001];
	// 	int currN = N;
	// 	int currQSize = 1;
	// 	int second = 0;
	// 	q.add(N);

	// 	while(currN != K) {
	// 		int nextN = 0;
			
	// 		nextN = currN + 1;
	// 		compare(nextN ,visit ,beforeNs ,currN ,q);
	// 		// if(nextN <= 100000 && !visit[nextN]) {
	// 		// 	visit[nextN] = true;
	// 		// 	beforeNs[nextN] = currN;		// 이전 수 저장.
	// 		// 	q.add(nextN);
	// 		// }

	// 		nextN = currN - 1;
	// 		compare(nextN, visit, beforeNs, currN, q);
	// 		// if(0 <= nextN && !visit[nextN]) {
	// 		// 	visit[nextN] = true;
	// 		// 	beforeNs[nextN] = currN;
	// 		// 	q.add(nextN);
	// 		// }

	// 		nextN = currN * 2;
	// 		compare(nextN, visit, beforeNs, currN, q);
	// 		// if(nextN <= 100000 && !visit[nextN]) {
	// 		// 	visit[nextN] = true;
	// 		// 	beforeNs[nextN] = currN;
	// 		// 	q.add(nextN);
	// 		// }
			
	// 		if(currQSize == 0) {
	// 			currQSize = q.size();
	// 			second++;
	// 		}
	// 		currN = q.poll();
	// 		currQSize--;
	// 	}
	// 	System.out.println(second);
	// 	int beforeN = 0;
	// 	int route[] = new int[second + 1];
	// 	route[second] = currN;
	// 	for(int i = second - 1; i >= 0; i--) {
	// 		beforeN = beforeNs[currN];
	// 		route[i] = beforeN;
	// 		currN = beforeN;
	// 	}
		
	// 	for(int i : route) {
	// 		System.out.print(i);
	// 		System.out.print(" ");
	// 	}
	// }

	// public static void compare(int nextN, boolean[] visit, int[] beforeNs, int currN, Queue<Integer> q) {
	// 	if (0 <=  nextN && nextN <= 100000 && !visit[nextN]) {
	// 		visit[nextN] = true;
	// 		beforeNs[nextN] = currN; // 이전 수 저장.
	// 		q.add(nextN);
	// 	}
	// }
}

class Solution {

	public void bfs(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		int[] beforeNs = new int[100001]; // 예전 수를 저장해볼까?
		boolean[] visit = new boolean[100001];
		int currN = N;
		int currQSize = 1;
		int second = 0;
		q.add(N);

		while (currN != K) {
			int nextN = 0;

			nextN = currN + 1;
			compare(nextN, visit, beforeNs, currN, q);
			// if(nextN <= 100000 && !visit[nextN]) {
			// visit[nextN] = true;
			// beforeNs[nextN] = currN; // 이전 수 저장.
			// q.add(nextN);
			// }

			nextN = currN - 1;
			compare(nextN, visit, beforeNs, currN, q);
			// if(0 <= nextN && !visit[nextN]) {
			// visit[nextN] = true;
			// beforeNs[nextN] = currN;
			// q.add(nextN);
			// }

			nextN = currN * 2;
			compare(nextN, visit, beforeNs, currN, q);
			// if(nextN <= 100000 && !visit[nextN]) {
			// visit[nextN] = true;
			// beforeNs[nextN] = currN;
			// q.add(nextN);
			// }

			if (currQSize == 0) {
				currQSize = q.size();
				second++;
			}
			currN = q.poll();
			currQSize--;
		}
		System.out.println(second);
		int beforeN = 0;
		int route[] = new int[second + 1];
		route[second] = currN;
		for (int i = second - 1; i >= 0; i--) {
			beforeN = beforeNs[currN];
			route[i] = beforeN;
			currN = beforeN;
		}

		for (int i : route) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void compare(int nextN, boolean[] visit, int[] beforeNs, int currN, Queue<Integer> q) {
		if (0 <= nextN && nextN <= 100000 && !visit[nextN]) {
			visit[nextN] = true;
			beforeNs[nextN] = currN; // 이전 수 저장.
			q.add(nextN);
		}
	} 
}
