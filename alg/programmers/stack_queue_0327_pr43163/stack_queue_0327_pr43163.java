// 프로그래머스 - DFS/BFS - 단어변환
package alg.programmers.stack_queue_0327_pr43163;
import java.util.Queue;
import java.util.LinkedList;

public class stack_queue_0327_pr43163 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(sol.solution(begin, target, words));
	}
}

class Solution {
    public int solution(String begin, String target, String[] words) {
		int answer = 0;
		Queue<String> q = new LinkedList<>();
		boolean[] visit = new boolean[words.length];
		String currWord = begin;
		
		int currQSize = 1;
		q.add(begin);	// begin

		// 목표에 도달할 때 까지
		while(!currWord.equals(target)){

			// 목표에 도달하지 못했는데, Queue가 비어 있을 경우 
			if(q.isEmpty()) {
				answer = 0;
				break;
			}

			// answer: 현재 몇 번째 Depth인지 체크
			if(currQSize == 0) {
				currQSize = q.size();
				answer++;
			}

			currWord = q.poll();
			currQSize--;

			for(int i = 0; i < words.length; i++) {		// words와 비교
				int diffCharNum = 0;

				if(!visit[i]) {							// 아직 검사하지 않았다면
					for(int j = 0; j < begin.length(); j++) {		// 각 char 비교
						if(currWord.charAt(j) != words[i].charAt(j)) {
							diffCharNum++;
							if(diffCharNum > 1) {
								break;
							} 
						}
					}
					if(diffCharNum == 1) {				// 문자가 1개만 같다면
						q.add(words[i]);
						visit[i] = true;
					}
				}
			}
		}
		return answer;
    }
}