package alg.DP;
import java.util.*;

public class dp_05_15988 {
	static int DIVIDE = 1000000009;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[1000001];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for (int j = 4; j <= 1000000; j++) {
			d[j] = ((d[j - 1] + d[j - 2]) % DIVIDE + d[j - 3]) % DIVIDE;
		}

		for(int i = 0; i < n; i++) {
			int input;
			input = sc.nextInt();
			System.out.println(d[input]);
		}
	}
}