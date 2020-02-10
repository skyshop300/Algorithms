package alg.samsungExpert;
import java.util.Scanner;
import java.util.*;

class codingTornament
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int k = sc.nextInt();
			int n = 1;
			for(int i = 0; i < k; i++) {
				n *= 2;
			}
			int boringScore = 0;
			int a = 0;
			int b = 0;
			int total = 0;
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i < n + 1; i++) {
				q.add(sc.nextInt());
			}
			while(q.size() > 1) {
				int winner = 0;
				a = q.poll();
				b = q.poll();
				if(a - b > 0) {
					boringScore = a - b;
					winner = a;
				} else {
					boringScore = b - a;
					winner = b;
				}
				total += boringScore;
				q.add(winner);
			}
			System.out.println("#" + test_case + " " + total);
		}
	}
}