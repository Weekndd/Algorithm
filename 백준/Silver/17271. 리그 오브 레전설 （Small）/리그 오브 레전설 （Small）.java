import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int div = 1000000007;
    	long[][] dp = new long[2][N+1];
    	dp[0][0] = 1;
    	for(int i=1; i<=N; i++) {
    		if(i-M<0) {
    			dp[0][i] = 1;
    			continue;
    		}
    		dp[0][i] = (dp[0][i-1]+dp[1][i-1])%div;
    		dp[1][i] = (dp[0][i-M]+dp[1][i-M])%div;
    	}
    	System.out.println((dp[0][N]+dp[1][N])%div);
    }//end main
}