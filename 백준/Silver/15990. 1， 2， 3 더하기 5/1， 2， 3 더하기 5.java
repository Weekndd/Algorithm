import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int MOD = 1000000009;
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i=4; i<100001; i++) {
        	dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
        	dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
        	dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }
        for(int t=0; t<T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	sb.append((dp[N][1]+dp[N][2]+dp[N][3]) % MOD +"\n");
        }
        System.out.println(sb);
    }//end main
}