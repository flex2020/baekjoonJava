package gold;
/* 골드5 1041번 주사위 풀이 */

import java.math.BigInteger;
import java.util.*;

public class p1041 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long N = sc.nextLong();
        long[] dice = new long[6];
        BigInteger answer = new BigInteger("0");


        BigInteger oneMin = new BigInteger("987654321");
        BigInteger twoMin = new BigInteger("987654321");
        BigInteger threeMin = new BigInteger("987654321");

        BigInteger topMin = new BigInteger("987654321");
        BigInteger bottomMin = new BigInteger("987654321");

        long max = 0;
        long total = 0;
        for(int i=0; i<6; i++) {
            dice[i] = sc.nextInt();
            total += dice[i];
            if(max < dice[i]) max = dice[i];
            if(oneMin.compareTo(BigInteger.valueOf(dice[i])) == 1) oneMin = BigInteger.valueOf(dice[i]);
        }
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                if((i != j) && (i+j != 5) && (twoMin.compareTo(BigInteger.valueOf(dice[i]+dice[j]))) == 1) twoMin = BigInteger.valueOf(dice[i] + dice[j]);
                for(int k=0; k<6; k++) {
                    if((i != j) && (j != k) && (k != i) && i+j != 5 && j+k != 5 && k+i != 5 && (threeMin.compareTo(BigInteger.valueOf(dice[i]+dice[j]+dice[k]))) == 1) threeMin = BigInteger.valueOf(dice[i] + dice[j] + dice[k]);
                }
            }
        }

        if(N==1) {
            System.out.println(total - max);
        }
        else {
            bottomMin = (oneMin.multiply(BigInteger.valueOf((N-2)*4))).add(twoMin.multiply(BigInteger.valueOf(4)));
            topMin = ((oneMin.multiply(BigInteger.valueOf((N-2)*(N-2)))).add(twoMin.multiply(BigInteger.valueOf((N-2)*4)))).add(threeMin.multiply(BigInteger.valueOf(4)));

            answer = bottomMin.multiply(BigInteger.valueOf((N-1))).add(topMin) ;
            System.out.println(answer);
        }

    }
}
