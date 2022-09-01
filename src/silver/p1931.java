package silver;

import java.util.*;

public class p1931 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        long[][] times = new long[N][2];
        boolean[] check = new boolean[N];
        for(int i=0; i<N; i++) {
            times[i][0] = sc.nextLong();
            times[i][1] = sc.nextLong();
        }
        long lastEnd = 0;
        // sort
        Arrays.sort(times, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] > o2[1]) return 1;
                else if(o1[1] < o2[1]) return -1;
                else {
                    if(o1[0] > o2[0]) return 1;
                    else return -1;
                }
            }
        });
        long cnt = 1;
        long end = times[0][1];
        for(int i=1; i<N; i++) {
            if(end <= times[i][0]) {
                cnt++;
                end = times[i][1];
            }
        }

        System.out.println(cnt);
    }
}
