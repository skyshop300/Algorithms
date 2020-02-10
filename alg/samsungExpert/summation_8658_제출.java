package alg.samsungExpert;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			int min = 0;
			int max = 0;

			for(int i = 0; i < 10; i++) {
				String str = sc.next();
				int curNum = 0;
				for(int k = 0; k < str.length(); k++) {
					curNum += str.charAt(k) - '0';
				}
				
				if(min > curNum || i == 0 ) {
					min = curNum;
				}
				if(max < curNum) {
					max = curNum;
				}
			}
			System.out.println("#" + test_case + " " + max + " " + min);
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}