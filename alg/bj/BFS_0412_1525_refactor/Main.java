package alg.bj.BFS_0412_1525_refactor;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();

		int[][] puzzle = new int[3][3];

		for(int i = 0; i < 3; i++) {
			for(int j = 0 ; j < 3; j++) {
				puzzle[i][j] = sc.nextInt();
			}
		}
		System.out.println(sol.solution(puzzle));
	}
}
class Solution {
	public int solution(int[][] puzzle) {
		int[] d = {-3, 1, 3, -1};
		Map<Integer, Boolean> visit = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		
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

		while(!q.isEmpty()) {
			if(currQSize == 0) {
				currQSize = q.size();
				depth++;
			}
			currPuzzleInt = q.poll();
			currQSize--;

			int nine = Integer.toString(currPuzzleInt).indexOf("9");

			for(int i = 0; i < 4; i++) {
				if((!(d[i] + nine > -1 && d[i] + nine < 9) || (nine % 3 == 0 && d[i] == -1) || (nine % 3 == 2 && d[i] == 1) )) {
					continue;
				}

				int nextInt= swap(currPuzzleInt, nine, d[i] + nine);
				if (!visit.containsKey(nextInt)) {
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
	
	public int swap(int currPuzzleInt, int currPosition, int nextPosition) {
		String currPuzzleStr = Integer.toString(currPuzzleInt);
		StringBuilder sb = new StringBuilder();
		sb.append(currPuzzleInt);
		sb.setCharAt(currPosition, currPuzzleStr.charAt(nextPosition));
		sb.setCharAt(nextPosition, currPuzzleStr.charAt(currPosition));

		return Integer.parseInt(sb.toString());
	}
}