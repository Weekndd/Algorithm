import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] ergs = new int[N+1][2];
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ergs[i][0] = Integer.parseInt(st.nextToken()); //small
			ergs[i][1] = Integer.parseInt(st.nextToken()); //big
		}
		int K = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			Arrays.fill(dp[i],1000000000);
		}
		
		dp[1][0] = 0;
		for(int i=1; i<=N; i++) {
			int small = ergs[i][0];
			int big = ergs[i][1];
			
			if(i+1<=N) {
				dp[i+1][0] = Math.min(dp[i][0]+small, dp[i+1][0]);
				dp[i+1][1] = Math.min(dp[i][1]+small, dp[i+1][1]);
			}
			if(i+2<=N) {
				dp[i+2][0] = Math.min(dp[i][0]+big, dp[i+2][0]);
				dp[i+2][1] = Math.min(dp[i][1]+big, dp[i+2][1]);
			}
			if(i+3<=N) dp[i+3][1] = Math.min(dp[i][0]+K, dp[i+3][1]);
		}
		System.out.println(Math.min(dp[N][0],dp[N][1]));
	}//end main
}
