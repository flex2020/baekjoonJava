package silver;
/* 실버4 1246번 온라인 판매 풀이 */

import java.util.*;

public class p1246 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N, M;

        N = sc.nextInt();
        M = sc.nextInt();

        int P[] = new int[M];
        int arr[] = new int[M];

        for(int i=0; i<M; i++) P[i] = sc.nextInt();

        Arrays.sort(P);

        int revnueMax = 0;
        int ansPrice = 0;
        int curPrice = 0;
        for(int i=0; i<M; i++) {
            curPrice = P[i];
            int canBuy = 0;
            if(N >= M-i) canBuy = M-i;
            else canBuy = N;
            if(revnueMax < curPrice*canBuy) {
                revnueMax = curPrice*canBuy;
                ansPrice = P[i];
            }
        }
        System.out.println(ansPrice + " " + revnueMax);
    }
}
