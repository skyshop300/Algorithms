package alg.bj.DP;
import java.util.*;

public class DP_03_11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];

		d[1] = 1;
		if(n >= 2) {
			d[2] = 3;
		}
		for(int i = 3; i <= n; i++) {
			d[i] = d[i-1] + d[i-2] * 2;		// 핵심
			d[i] %= 10007;
		}
		System.out.println(d[n]);
	}
}