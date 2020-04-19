/*
백준 - 9019 - DSLR
https://www.acmicpc.net/problem/9019
D: 2n % 10000
S: n-1 0->9999
L: n을 왼편으로 회전시킨다.
R: n을 오른편으로 회전시킨다.
*/
package alg.bj.BFS_0411_9019;
import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	public static void main(String[] args) {
		Runtime.getRuntime().gc();
		// 비교 직전에 gc 를 사용해서 garbage collection을 실행하도록 하면 보다 더 정확하게 메모리 소비량을 얻을 수 있다.
		
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		for(int i = 0; i < T; i++) {
			Solution sol = new Solution();
			int A = sc.nextInt();
			int B = sc.nextInt();
			sol.solution(A, B);	
		}

		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		System.out.println("used memory is " + used + " bytes");
	}
}

class Solution {
	public void solution(int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		char[] operators = new char[10001];
		int[] beforeNums = new int[10001];
		boolean[] visit = new boolean[10001];
		int currA = A;
		int nextA = 0;
		visit[currA] = true;

		// 무조건 답에 도달하는가?
		while(currA != B) {
			int excessNum = 0;
			// D
			nextA = currA * 2 % 10000;
			if(!visit[nextA]) {
				visit[nextA] = true;
				operators[nextA] = 'D';
				beforeNums[nextA] = currA;
				q.add(nextA);
			}

			// S
			nextA = currA - 1;
			if(nextA > -1  && !visit[nextA]) {
				visit[nextA] = true;
				operators[nextA] = 'S';
				beforeNums[nextA] = currA;
				q.add(nextA);
			} else if (nextA == -1 && !visit[9999]){
				visit[9999] = true;
				operators[9999] = 'S';
				beforeNums[9999] = currA;
				q.add(9999);
			}

			// L
			excessNum = currA / 1000;
			nextA = currA % 1000 * 10 + excessNum;
			if(!visit[nextA]) {
				visit[nextA] = true;
				operators[nextA] = 'L';
				beforeNums[nextA] = currA;
				q.add(nextA);
			}

			// R
			excessNum = currA % 1000 % 100 % 10;
			nextA = excessNum * 1000 + currA / 10;
			if(!visit[nextA]) {
				visit[nextA] = true;
				operators[nextA] = 'R';
				beforeNums[nextA] = currA;
				q.add(nextA);
			}
			currA = q.poll();
		}
		
		Stack<Character> stack = new Stack<>();

		while(currA != A) {
			stack.add(operators[currA]);
			currA = beforeNums[currA];
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}
}

