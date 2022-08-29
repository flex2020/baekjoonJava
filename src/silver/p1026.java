package silver;
/* 실버4 1026번 보물 풀이 */

import java.util.*;

public class p1026 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        Long s = 0L;

        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];

        for(int i=0; i<N; i++) {
            a[i] = sc.nextInt();
        }
        Integer max = 0;
        for(int i=0; i<N; i++) {
            b[i] = sc.nextInt();
            if(max < b[i]) max = b[i];
        }
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            s += a[i]*b[i];
        }
        System.out.println(s);
    }
}
