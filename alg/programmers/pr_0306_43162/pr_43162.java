package alg.programmers.pr_0306_43162;
public class pr_43162 {
	public static void main(String[] args) {
		int n = 3;													// 컴퓨터의 갯수
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};		// 연결 map
		Solution sol = new Solution();
		System.out.println(sol.solution(n, computers));
	}
}

class Solution {
    public int solution(int n, int[][] computers) {
		boolean[] visited = new boolean[n];
        int answer = 0;
		for(int i = 0; i < computers.length; i++) {
			if(!visited[i]) {
				visited = dfs(i, computers, visited);
				answer++;
			}
		}
        return answer;
    }

	public boolean[] dfs(int start, int[][] computers, boolean[] visited) {
		visited[start] = true;
		for(int i = 0; i < computers[0].length; i++) {
			if(computers[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				visited = dfs(i, computers, visited);
			}
		}
		return visited;
	}
}