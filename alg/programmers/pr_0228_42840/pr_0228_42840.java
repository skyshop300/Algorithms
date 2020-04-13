// 프로그래머스 - 42840 모의고사
package alg.programmers.pr_0228_42840;
import java.util.*;

public class pr_0228_42840 {
	public static void main(String[] args) {
		int[] answers = { 3,2,2,4,2, 1,4,5,1,2, 3,2,2,4,2, 1,4,5,1,5};
		Solution sol = new Solution();
		int[] answer = sol.solution(answers);
		for(int i = 0; i < answer.length; i++) {
			System.out.println("answer" + answer[i]);
		}
	}
}

class Solution {
    public int[] solution(int[] answers) {
		int[] first = 	{1,2,3,4,5};
		int[] second = 	{2,1,2,3,2,4,2,5};
		int[] third = 	{3,3,1,1,2,2,4,4,5,5};
		int firstNum = 0;
		int secondNum = 0;
		int thirdNum = 0;
		
		for(int i = 0; i < answers.length; i++) {
			int anAnswer = answers[i];
			
			System.out.println(anAnswer);
			if(first[i % 5] == anAnswer) {
				firstNum++;
			}
			if(second[i % 8] == anAnswer) {
				secondNum++;
			}
			if(third[i % 10] == anAnswer) {
				thirdNum++;
			}
		}

		List<Integer> list = new ArrayList<>();

		if(firstNum >= secondNum && firstNum >= thirdNum) {
			list.add(1);
		} 
		if(secondNum >= firstNum && secondNum >= thirdNum) {
			list.add(2);
		} 
		if(thirdNum >= firstNum && thirdNum >= secondNum) {
			list.add(3);
		}

		int[] answer = new int[list.size()];
		int size = 0;
		for(int num : list) {
			answer[size++] = num;
		}

        return answer;
    }
}