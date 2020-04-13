// 백준15990: 1,2,3 더하기 5
package alg.bj.DP;
import java.util.*;

public class dp_08_15990 {
	static final int dn = 1000000009;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long [][] d = new long[100001][4];

		d[1][1] = 1;
		d[2][2] = 1;	// 2
		d[3][1] = 1;	// 2,1 
		d[3][2] = 1;	// 1,2  
		d[3][3] = 1;	// 3

		for(int i = 4; i < 100001; i++) {
			d[i][1] = (d[i-1][2] + d[i-1][3]) % dn;
			d[i][2] = (d[i-2][1] + d[i-2][3]) % dn;
			d[i][3] = (d[i-3][1] + d[i-3][2]) % dn;
		}

		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int input = sc.nextInt();
			System.out.println(((d[input][1] + d[input][2]) % dn + d[input][3]) % dn);
		}
	}
}