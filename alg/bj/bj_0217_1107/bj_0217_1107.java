package alg.bj.bj_0217_1107;
import java.util.*;

// 모든 경우의 수를 구하고
// 고장난 경우를 제외해버린다.
public class bj_0217_1107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean[] isBroken = new boolean[10];
		// 찾아갈 채널
		int[] nums = new int[str.length()];
		// 낮은 수 
		int[] lowNums = new int[str.length()];
		// 높은 수
		int[] highNums = new int[str.length()];

		for(int i = 0; i < str.length(); i++) {
			nums[i] = str.charAt(i) - '0';
		}

		int m = sc.nextInt();
		int brokenButton = 0;
		for(int i = 0; i < m; i++) {
			brokenButton = sc.nextInt();
			isBroken[brokenButton] = true;
		}

		// broken Button 입력 정상
		/* for(int i = 0; i < isBroken.length; i++) {
			System.out.println("i: " + i + " isBroken[i]: "  + isBroken[i]);
		} */

		// 가장 가까운 수를 찾자
		for(int i = 0; i < nums.length; i++) {
			// 보다 작은 가까운 수
			int currNum = nums[i];
			while(currNum > -1 && isBroken[currNum]) {
				currNum--;
			}
			lowNums[i] = currNum;
			System.out.println("lowNums[" + i + "]: " + lowNums[i]);

			if(nums[i] == currNum) {
				highNums[i] = currNum;
				continue;
			}

			// 보다 큰 가까운 수
			currNum = nums[i];
			while(currNum < 10 && isBroken[currNum]) {
				currNum++;
			}
			highNums[i] = currNum;
			System.out.println("highNums[" + i + "]: " + highNums[i]);
		}

		for(int i = 0; i < nums.length; i++) {
			int lowNumDiffer = nums[i] - lowNums[i];		// 절대값
			int highNumDiffer = highNums[i] - nums[i];		// 절대값
			boolean isLow = false;
			if(nums[i] == lowNums[i]) {
				nums[i] = lowNums[i];
			} else if(lowNumDiffer == highNumDiffer) {
				nums[i] = -1;
			} else if(lowNumDiffer > highNumDiffer || lowNums[i] == -1) {
				int j = i - 1;
				isLow = false;
				while(j > -1 && nums[j] == -1) {
					if(!isLow) {
						nums[j] = highNums[j];
						isLow = true;
					} else {
						nums[j] = lowNums[j];
						isLow = false;
					}
					j--;
				}
				nums[i] = lowNums[i];
			} else if(lowNumDiffer < highNumDiffer || highNums[i] == 10) {
				int j = i - 1;
				isLow = true;
				while(j > -1 && nums[j] == -1) {
					if(!isLow) {
						nums[j] = highNums[j];
						isLow = true;
					} else {
						nums[j] = lowNums[j];
						isLow = false;
					}
					j--;
				}
				nums[i] = highNums[i];
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}

// 5770
// 5580
// 5370
// 보다 크면 적어야 유리
// 보다 적으면 커야 유리