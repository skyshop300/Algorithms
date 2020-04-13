package alg.bj.DP;
import java.util.*;

public class dp_07_16194 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n+1];

		p[0] = 0;
		for(int i = 1; i <= n; i++) {
			p[i] = sc.nextInt();
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= i / 2; j++) {
				if(p[i-j] + p[j] < p[i]) {
					p[i] = p[i-j] + p[j];
				}
			}
		}
		System.out.println(p[n]);
	}
}