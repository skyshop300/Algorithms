// 백준1463: 1로 만들기 - DP 이용
package alg.bj.DP;
import java.util.*;

public class dp_01_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		d[1] = 0;

		for(int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1;						// 3번
			if(i % 2 == 0 && d[i] > d[i/2] + 1) {		// 2번 // 이전 계산을 확인해보고 더욱 효과적인 결과를 찾는다
				d[i] = d[i / 2] + 1;
			}
			if(i % 3 == 0 && d[i] > d[i/3] + 1) {		// 1번
				d[i] = d[i / 3] + 1;
			}
		}
		System.out.println(d[n]);
	}
}