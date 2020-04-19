package alg.bj.BFS_0414_2251_ref;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] a = new int[3];
 
        for(int i=0; i<3; i++) {
            a[i] = scan.nextInt();
        }
 
        int [] from = {0, 0, 1, 1, 2, 2}; 
        int [] to = {1, 2, 0, 2, 0, 1};
        boolean [][]check = new boolean[201][201];
        boolean [] ans = new boolean[201];
        Queue<Pair> q = new LinkedList<>();
 
        q.add(new Pair(0, 0));
        check[0][0] = true;
        ans[a[2]] = true;
 
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = a[2]-x-y;
 
            for(int k=0; k<6; k++) {
                int [] next = {x, y, z};
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;
 
                if(next[to[k]] > a[to[k]]) { //물통의 용량보다 물이 많을 때
                    next[from[k]] = next[to[k]] - a[to[k]]; //초과하는 만큼 다시 넣어주고
                    next[to[k]] = a[to[k]]; //용량에 가득 찬 물을 넣어준다.
                }
                if(!check[next[0]][next[1]]) {
                    check[next[0]][next[1]] = true;
                    q.add(new Pair(next[0], next[1]));
                    if(next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for(int i=0; i<=a[2]; i++) {
            if(ans[i])
                System.out.print(i+ " ");
        }
    }
 
}
class Pair{
    int x;
    int y;
 
    public Pair(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
