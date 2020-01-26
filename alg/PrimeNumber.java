package alg;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();

		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		System.out.println(isPrime(num));
		sc.close();
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime) / 1000; // 두 시간에 차 계산
		System.out.println("시간차이(m) : " + secDiffTime);

	}

	public static boolean isPrime(long n) {
		if(n < 2) {
			return false;
		}
		for(long i=2; i*i<=n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}