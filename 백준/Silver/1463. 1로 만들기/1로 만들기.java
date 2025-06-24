import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			int A = Integer.MAX_VALUE;
			int B = Integer.MAX_VALUE;
			if(i%2 ==0) {
				A = dp[i/2];
			}
			if(i%3==0) {
				B = dp[i/3];
			}
			dp[i] = Math.min(A, Math.min(B, dp[i-1]))+1;
		}
		System.out.println(dp[N]);
	}//end main
}