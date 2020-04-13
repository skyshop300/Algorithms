package alg.bj;
import java.util.*;

public class graph_10_14226 {
	static final int MAX = 1000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dest = sc.nextInt();
		int answer = bfs(dest);
		System.out.println(answer);
	}
	public static int bfs(int dest) {
		
		int second = 0;
		int clipboard = 0;
		int display = 1;
		int nextDisplay = 0;
		int currentSize = 0;

		if(display == dest) {
			return second;
		}

		boolean visit[][] = new boolean[MAX + 1][MAX + 1];		// 가지치기용.
		Queue<Status> q = new LinkedList<Status>();
		Status currentStatus;
		q.add(new Status(clipboard, display));
		visit[0][1] = true;

		while(!q.isEmpty()) {
			if(currentSize == 0) {
				second++;
				currentSize = q.size();
			}
			currentSize--;
			
			currentStatus = q.poll();
			clipboard = currentStatus.clipboard;
			display = currentStatus.display;

			// 1. 클립보드에 저장
			if(clipboard != display && !visit[display][display]) {
				visit[display][display] = true;
				q.add(new Status(display, display));
			}

			// 2. 화면에 붙여넣기.
			nextDisplay = display + clipboard;
			if(nextDisplay == dest) {
				break;
			}
			if(nextDisplay < MAX + 1 && !visit[clipboard][nextDisplay] )  {
				visit[clipboard][nextDisplay] = true;
				q.add(new Status(clipboard, nextDisplay));
			}

			// 3. -1
			nextDisplay = display - 1;
			if(nextDisplay == dest) {
				break;
			}
			if(nextDisplay > 0 && !visit[clipboard][nextDisplay]) {
				visit[clipboard][nextDisplay] = true;
				q.add(new Status(clipboard, nextDisplay));
			}
		}
		return second;
	}
}

class Status {
	int clipboard;
	int display;
	public Status(int clipboard, int display) {
		this.clipboard = clipboard;
		this.display = display;
	}
}