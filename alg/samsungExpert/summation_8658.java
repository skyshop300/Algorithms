package alg.samsungExpert;
import java.util.*;

public class summation_8658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int min[] = new int[t];
		int max[] = new int[t];

		for(int i = 0; i < t; i++) {
			// int[] nums = new int[10];
			for(int j = 0; j < 10; j++) {
				String str = sc.next();
				int curNum = 0;
				for(int k = 0; k < str.length(); k++) {
					curNum += str.charAt(k) - '0';
				}
				
				if(min[i] > curNum || j == 0 ) {
					min[i] = curNum;
				}
				if(max[i] < curNum) {
					max[i] = curNum;
				}
			}
		}
		for(int i = 0; i < t; i++) {
			System.out.println("#" + (i+1) + " " + max[i] + " "+ min[i]);
		}
	}
}