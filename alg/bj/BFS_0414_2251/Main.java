package alg.bj.BFS_0414_2251;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sol.solution(A, B, C);
	}
}
class Solution {
	public void solution(int A, int B, int C) {
		Queue<int[]> q = new LinkedList<>();			// 현재 물통용량 Snapshot
		int[] volume = {A, B, C};	// 현재 용량		// 0: A, 1: B, 2: C
		int[] currVol = {0, 0, C};	// 현재 용량		// 0: A, 1: B, 2: C
		ArrayList<Integer> answer =  new ArrayList<>();
		q.add(currVol);
		boolean[][][] visit = new boolean[201][201][201];		// visit
		visit[0][0][C] = true;
		answer.add(C);

		while(!q.isEmpty()) {
			currVol = q.poll();
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if (i == j || currVol[i] == 0) {
						continue;
					}
					
					int sender = 0;
					int receiver = 0;

					if(currVol[i] + currVol[j] > volume[j]) {	// volume보다 넘친다면
						sender = currVol[i] - (volume[j] - currVol[j]);		// 
						receiver = volume[j];					// receiver는 꽉찬다.
					} else {
						sender = 0;
						receiver = currVol[i] + currVol[j];
					}

					int[] inputVol = new int[3];	
					inputVol[i] = sender;
					inputVol[j] = receiver;
					inputVol[3 - i - j] = currVol[3 - i - j];
					
					if(inputVol[2] == 100) {
						inputVol[i] = sender;
						inputVol[j] = receiver;
						inputVol[3 - i - j] = currVol[3 - i - j];
					}

					// 방문 여부 확인.
					if(!visit[inputVol[0]][inputVol[1]][inputVol[2]]) {							// 아직 방문하지 않은 곳.
						visit[inputVol[0]][inputVol[1]][inputVol[2]] = true;					
						if (inputVol[0] == 0) { // A가 0 일때에
							answer.add(inputVol[2]);
						}
						q.add(inputVol);
					}
				}
			}
		}
		Collections.sort(answer);
		for(int a : answer) {
			System.out.print(a + " ");
		}
	}
}