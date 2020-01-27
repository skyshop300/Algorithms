package alg.bruteForce;
import java.util.Arrays;
import java.util.Scanner;

public class bj_02_2309 {
	public static void main(String[] args) {
		int[] height = new int[9];
		int heightSum = 0;
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < height.length; i++) {
			height[i] = sc.nextInt();
			heightSum += height[i];
		}

		Arrays.sort(height);

		for(int i = 0; i < height.length; i++) {
			for(int j = 0; j < height.length; j++) {
				int heightSumTemp = heightSum;
				heightSumTemp -= height[i];
				heightSumTemp -= height[j];
				if(heightSumTemp == 100) {
					for(int k = 0 ; k < height.length; k++) {
						if(!(k == i || k == j)) {
							System.out.println(height[k]);
						} 
					}
					System.exit(0);
				}
			}
		}
	}
}