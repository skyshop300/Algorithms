// package alg;
// import java.util.Scanner;

// public class bj_9613 {
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int t = sc.neAxtInt();
// 		int[] nums = new int[t];

// 		for(int i = 0; i < t; i++) {
// 			String textNums = sc.next();
// 			String[] numStringTemp = textNums.split(" ");
// 			for(int j = 0; j <  numStringTemp.length; j++) {
// 				int[] numTemp = new int[numStringTemp.length];
// 				numTemp[j] = Integer.parseInt(numStringTemp[j]);
// 			}
// 		}
// 	}


// 	public static int gcd(int a, int b) {
// 		while(b != 0) {
// 			int r = a % b;
// 			a = b;
// 			b = r;
// 		}
// 		return a;
// 	}

// }