import java.io.*;
import java.util.*;

public class Main {  //백준 2302번 극장좌석
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NUM = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] vip = new int[N];
        for(int i=0; i<N; i++) {
        	vip[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=40; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        
        int ans = 1;
        int prev = 0;
        for(int v : vip) {
        	int leng = v-prev-1;
        	ans *= dp[leng];
        	prev = v;
        }
        ans *= dp[NUM-prev];
        System.out.println(ans==0?1:ans);
    }//end main
}