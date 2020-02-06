// 백준11052: 카드 구매하기
// 39 min
package alg.DP;
import java.util.*;

public class dp_06_11052 {
	// static final MAX = 1000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			d[i] = sc.nextInt();
		}

		d[0] = 0;
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				if(d[i] < d[i-j] + d[j]) {
					d[i] = d[i-j] + d[j];
				}
			}
		}
		System.out.println(d[n]);
	}
}