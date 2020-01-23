package alg;
import java.util.Scanner;

public class bj_1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] lcms = new int[n];
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			lcms[i] = lcm(a, b);
		}
		for(int lcm: lcms) {
			System.out.println(lcm);
		}
	}

	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static int lcm (int a, int b) {
		int g = gcd(a, b);
		return a * b / g;
	}
}