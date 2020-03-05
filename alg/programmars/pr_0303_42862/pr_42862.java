package alg.programmars.pr_0303_42862;
public class pr_42862 {
	public static void main(String[] args) {
		int n = 5;						// 학생의 수
		int[] lost = {2,4};				// 옷을 잃어버린 학생의 번호
		int[] reserve = {1,3,5};				// 여분의 옷을 가지고 있는 학생의 번호
		Solution sol = new Solution();
		System.out.println(sol.solution(n, lost, reserve));
	}
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
		// lost: 본인 -> 작은놈 -> 큰놈 
		int answer = n - lost.length;
		boolean[] isLost = new boolean[n + 1];
		boolean[] isReserve = new boolean[n + 1];
		
		for (int i = 0; i < reserve.length; i++) {
			System.out.println("reserve" + reserve[i]);
			isReserve[reserve[i]] = true;
		}

		for (int i = 0; i < lost.length; i++) {
			if(isReserve[lost[i]]){
				isReserve[lost[i]] = false;
				answer++;
			} else {
				isLost[lost[i]] = true;
			}
		}

		for(int i = 1; i < n + 1; i++) {
			if(isLost[i]) {
				if(isReserve[i]) {
					answer++;
					isReserve[i] = false;
				} else if(isReserve[i - 1]) {
					answer++;
					isReserve[i - 1] = false;
				} else if(i != n && isReserve[i + 1]) {
					answer++;
					isReserve[i + 1] = false;
				}
			} 
		}
        return answer;
    }
}