// 백준11726: 2×n 타일링
package alg.bj.DP;
import java.util.*;

public class dp_02_11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];		// 2*n 직사각형을 채우는 방법의 수

		d[0] = 0;
		d[1] = 1;
		if(n >= 2) {
			d[2] = 2;
		}

		for(int i = 3; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
			d[i] %= 10007;
		}
		System.out.println(d[n]);
	}
}