package alg.bj;
import java.util.Scanner;

// 최대공약수와 최소공배수
public class bj_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int gcd = gcd(a,b);
		int lcm = lcm(a,b);

		System.out.println(gcd);
		System.out.println(lcm);
	}

	// 유클리드 호제법을 사용하여 GCD를 구함.
	public static int gcd(int a, int b) {
		while(b != 0) {
			int rest = a % b;
			a = b;
			b = rest;
		}
		return a;
	}

	public static int lcm(int a, int b) {
		a = a * b / gcd(a, b);
		return a;
	}
}