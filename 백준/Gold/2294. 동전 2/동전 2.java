import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N+1];
        for(int i=1; i<=N; i++) {
        	coins[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[K+1];
        int MAX = 1000000000;
        Arrays.fill(dp,MAX);
        dp[0] = 0;
        for(int i=1; i<=N; i++) {
        	int coin = coins[i];
        	for(int j=coin; j<=K; j++) {
        		dp[j] = Math.min(dp[j],dp[j-coin]+1);
        	}
        }
        System.out.println(dp[K]==MAX?-1:dp[K]);
    }//end main
}