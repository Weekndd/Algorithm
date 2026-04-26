import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] dp = new int[11];
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int j=4; j<=num; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			sb.append(dp[num]+"\n");
		}
		System.out.println(sb);
		
	}
}