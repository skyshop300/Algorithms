package alg.bj.bruteForce;
import java.util.Scanner;
public class bj_01_1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int eInput = sc.nextInt();
		int sInput = sc.nextInt();
		int mInput = sc.nextInt();

		int e = 0;
		int s = 0;
		int m = 0;
		int year = 0;

		while(true) {
			e++;
			s++;
			m++;
			year++;
			if(e == 16) {
				e = 1;
			}
			if(s == 29) {
				s = 1;
			}
			if(m == 20) {
				m = 1;
			}
			if(e == eInput && s == sInput && m == mInput) {
				System.out.println(year);
				sc.close();
				break;
			}
		}
	}
}