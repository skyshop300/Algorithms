package alg.programmers.pr_0309_49189;
import java.util.*;

// 최단거리를 구하되 모든 edge의 최단거리 -> BFS!

public class pr_49189 {
	public static void main(String[] args) {
		int n = 6;	// 노드의 갯수
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};	// MAP
		Solution sol = new Solution();
		System.out.println(sol.solution(n, edge));
	}
}

class Solution {
    public int solution(int n, int[][] edge) {
		Queue<Integer> q = new LinkedList<>();
		boolean[][] map = new boolean[n + 1][n + 1];
		boolean[] visit = new boolean[n + 1];
		int depthNum = 0;
		int currDepthNum = 1;
		int currEdge = 1;

		for(int i = 0; i < edge.length; i++) {
			int a = edge[i][0];
			int b = edge[i][1];
			map[a][b] = true;
			map[b][a] = true;
		}

		q.add(currEdge);
		visit[1] = true;

		while(true) {
			currEdge = q.poll();
			for(int j = 1; j < n + 1; j++) {
				if(map[currEdge][j] && !visit[j]) {
					visit[j] = true;
					q.add(j);
				}
			}

			if((q.isEmpty())) {
				break;
			}

			currDepthNum--;
			if(currDepthNum == 0) {
				currDepthNum = q.size();
				depthNum = currDepthNum;
			}

		} 

        int answer = depthNum;
        return answer;
    }
}