// 백준9095: DP - 1,2,3 더하기
package alg.bj.DP;
import java.util.*;
public class dp_04_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
		}
		
		for(int i : t) {
			int[] d = new int[11];				// 만들 수 있는 식의 갯수
			d[1] = 1;
			d[2] = 2;
			d[3] = 4;
			for(int j = 4; j <= i; j++) {
				d[j] = d[j-1] + d[j-2] + d[j-3];
			}
			System.out.println(d[i]);
		}
		sc.close();
	}
}