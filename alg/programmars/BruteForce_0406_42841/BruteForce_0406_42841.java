package alg.programmars.BruteForce_0406_42841;
import java.util.*;
// #순열
// 각 자리를 mod 해주는 번거로움이 있으므로 String으로 변형하자.
// !! 중복되는 수가 존재하면 안된다
// !! 0이 존재하면 안된다.

public class BruteForce_0406_42841 { 
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		// int[][] baseball = { { 123, 3, 0 } };
		// int[][] baseball = { { 123, 0, 1 }, { 456, 1, 0 } };
		// int[][] baseball = { { 123, 0, 0 } };
		// int[][] baseball = { { 123, 0, 0 }};
		// int[][] baseball = { { 123, 1, 1 }, { 156, 0, 2 }, {789, 0, 0}}; // 621
		System.out.println(sol.solution(baseball));
	}
}

class Solution {
    public int solution(int[][] baseball) {
		Queue<String> q = new LinkedList<>();

		for(int i = 123; i <= 987; i++) {
			q.add(Integer.toString(i));
		}

		for(int i = 0; i < baseball.length; i++) {
			String str = Integer.toString(baseball[i][0]);
			int num[] = new int[3];

			for(int j = 0; j < 3; j++) {
				num[j] = str.charAt(j) - '0';
			}

			int strikeNum = baseball[i][1];		// strike 횟수
			int ballNum = baseball[i][2];		// ball 횟수
			
			int qSize = q.size();
			// strike, ball 처리
			for(int h = 0; h < qSize; h++) {
				String qStr = q.poll();
				// 동일한 수가 존재하거나 0일 경우를 제외한다.
				if(qStr.charAt(0) == qStr.charAt(1) 
					|| qStr.charAt(1) == qStr.charAt(2)
					|| qStr.charAt(0) == qStr.charAt(2)
					|| qStr.charAt(0) == '0'
					|| qStr.charAt(1) == '0'
					|| qStr.charAt(2) == '0') {
						continue;
				}

				int strikeSameNum = 0;
				int ballSameNum = 0;
				for(int j = 0; j < 3; j++) {				// 각 자리수가 동일한지 검사.
					int qCurrNum = qStr.charAt(j) - '0';	// 현재 자리수의 숫자
					
					if(qCurrNum == num[j]) {				// Strike 한가?	// 동일 자리, 동일 수
						strikeSameNum++;
					} else {
						for (int k = 0; k < 3; k++) {	
							if (k != j && qCurrNum == num[k]) {	// Ball 한가? // 다른 자리, 동일 수
								ballSameNum++;
							}
						}
					}
				}
				if(strikeSameNum == strikeNum && ballSameNum == ballNum) {		// Strike 횟수 이상의 동일한 수가 있어야 한다.
					q.add(qStr);
					// System.out.println("qStr: " + qStr);
				}
			}
			// System.out.println("!!!!!!!!!!");
		}
		// System.out.println("answer: "+ q.size());
        return q.size();
    }
}

