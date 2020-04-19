package alg.bj.BFS_0412_1525_correct;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		// Runtime.getRuntime().gc();
		// // 비교 직전에 gc 를 사용해서 garbage collection을 실행하도록 하면 보다 더 정확하게 메모리 소비량을 얻을 수 있다.

		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();

		int[][] puzzle = new int[3][3];

		for(int i = 0; i < 3; i++) {
			for(int j = 0 ; j < 3; j++) {
				puzzle[i][j] = sc.nextInt();
			}
		}
		System.out.println(sol.solution(puzzle));

		// long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		// System.out.println("used memory is " + used + " bytes");
		
	}
}
class Solution {
	public int solution(int[][] puzzle) {
		int[] d = {-3, 1, 3, -1};
		Map<Integer, Boolean> visit = new HashMap<>();	// String: 전체 map // Intger: 0이 저장된 index;
		Queue<Integer> q = new LinkedList<>();
		
		//  dot = whereDOT(puzzle); 

		String currPuzzleStr = Integer.toString(puzzleToInt(puzzle));
		currPuzzleStr = currPuzzleStr.replace('0', '9');
		int currPuzzleInt = Integer.parseInt(currPuzzleStr);

		q.add(currPuzzleInt);
		visit.put(currPuzzleInt, true);
		int depth = 1;
		int currQSize = 1;

		if (currPuzzleInt == 123456789) {
			return 0;
		}

		// 방문하면 map에 추가.
		while(!q.isEmpty()) {							// 답에 도달하지 못 할 수 있으므로 isEmpty();
			if(currQSize == 0) {
				currQSize = q.size();
				depth++;
			}
			currPuzzleInt = q.poll();
			currQSize--;

			// puzzle = intToPuzzle(currPuzzleInt);

			int nine = Integer.toString(currPuzzleInt).indexOf("9");

			// int x = nine % 3;
			// int y = nine / 3;
			// DOT dot = new DOT(x, y);		// 빼먹었다...
			
			// -3, +3, -1, +1
			// map 이동
			for(int i = 0; i < 4; i++) {
				if(!(d[i] + nine > -1 && d[i] + nine < 9 )) {
					continue;
				}
				if (nine % 3 == 0 && i ==3) {
					continue;
				}
				else if (nine % 3 == 2 && i == 1) {
					continue;
				}
				
				// DOT nextDot = new DOT(dx[i] + x , dy[i] + y);
				int nextInt= swap(currPuzzleInt, nine, d[i] + nine);
				// q에 저장
				if (!visit.containsKey(nextInt)) {
					// System.out.println(nextPuzzleInt);
					if(nextInt == 123456789) {
						return depth;
					}
					visit.put(nextInt, true);
					q.add(nextInt);
				}
			}
		}
		return -1;
	}

	public int puzzleToInt(int[][] puzzle) {
		String str = "";
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				str += puzzle[i][j];
			}
		}
		int num = Integer.parseInt(str);
		return num;
	}
	// public int[][] intToPuzzle(int currPuzzleInt) {
	// 	String str = Integer.toString(currPuzzleInt);
	// 	int[][] puzzle = new int[3][3];
	// 	for(int i = 0; i < 9; i++) {
	// 		puzzle[i / 3][i % 3] = str.charAt(i) - '0';
	// 	}
	// 	return puzzle;
	// }
	public int swap(int currPuzzleInt, int currPosition, int nextPosition) {
		String currPuzzleStr = Integer.toString(currPuzzleInt);
		StringBuilder sb = new StringBuilder();
		sb.append(currPuzzleInt);
		
		sb.setCharAt(currPosition, currPuzzleStr.charAt(nextPosition));
		sb.setCharAt(nextPosition, currPuzzleStr.charAt(currPosition));

		return Integer.parseInt(sb.toString());
	}

}