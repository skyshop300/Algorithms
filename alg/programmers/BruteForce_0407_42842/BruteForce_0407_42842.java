// redHeight * redWidth == redNum
//(redHeight + redWidth) * 2 + 4  == brownNum
// redNum + brownNum = answer[0] * answer[1]
// 2 * 2 == 2 * 4
// 1 * 4 == 4 * 2 + 2
// 3 * 3 == 3 * 4
// 1 * 9 == 9 * 2 + 2

// 격자수의 약수에 의한 규칙이 존재한다.
// 1 * 24 = (24 * 2) + (1 * 2)
// 2 * 12 = (12 * 2) + (2 * 2)
// 3 * 8 = (8 * 2) + (3 * 2)
// n * m = (n + m) * 2
// brown + red = answer[0] * answer[1]

package alg.programmers.BruteForce_0407_42842;
public class BruteForce_0407_42842 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		// int brown = 10;
		// int red = 2;
		// int brown = 24;
		// int red = 24;
		int brown = 8;
		int red = 1;
		System.out.println(sol.solution(brown, red));
	}
}

class Solution {
    public int[] solution(int brown, int red) {
		int[] answer = new int[2];

		for(int i = 1; i <= red; i++) {
			if(red % i != 0) {
				continue;
			}
			if(brown == (i + red / i) * 2 + 4) {
				answer[0] = red / i + 2;
				answer[1] = i + 2;
				break;
			}
		}
        return answer;
    }
}
