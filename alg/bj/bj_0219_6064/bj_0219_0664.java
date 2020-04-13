package alg.bj.bj_0219_6064;
import java.util.Scanner;

// 배수 문제 같다.
public class bj_0219_0664 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int year = x;
			int answer = -1;
			int diff = m - n; // 를 더하라
			int currY = x;

			if(diff > 0) { // 양수 일때
				for(int j = 0; j < m ; j++) {
					year += m;
					currY = currY + diff;
					if(currY > n) {
						currY = currY % n ;
					} 
					if (currY == y || currY == 0) {
						answer = year;
						break;
					}
					System.out.println("currY: " + currY);
					System.out.println("year: " + year);
				}
			}
			else if (diff < 0) { // 음수 일때
				for (int j = 0; j < n / m; j++) {
					year += m;
					currY = currY + diff;
					if (currY < 1) {
						currY = n - (currY * -1) % n ;
					}
					if (currY == y || currY == 0) {
						answer = year;
						break;
					}
				}
			}
			else if (diff == 0) {
				if(x != y) {
					answer = -1;
				} else {
					answer = x;
				}
			}
			System.out.println(answer);
		}
	}
}

// 10 12 3 9
// 3 3
// 1 10
// 3 1
// 1 8
// 3 10
// 1 6
// 3 8

// 5 11 2 7
// 2 2
// 1 6
// 2 7
// 1 11
// 2 1
// 1 5
// 2 6

// 5 20 2 7
// 2 2
// 1 5
// 2 6
// 1 9
// 2 10
// 2 14
// 2 18

// 2 2

// 나왔던 것이 또나오면 무한루프이다.

// 11 5 2 7
// 2 2
// 1 3
// 2 4 

/*
6
10 12 3 9
10 12 7 2
13 11 5 6
1 1 1 1
3 7 2 3 
40000 40000 2 3
*/