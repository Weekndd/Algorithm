import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[P+1][2];
		for(int i=1; i<=P; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[D+1];
		dp[0] = Integer.MAX_VALUE;
		for(int i=1; i<=P; i++) {
			for(int j=D; j>=arr[i][0]; j--) {
				dp[j] = Math.max(dp[j], Math.min(dp[j-arr[i][0]], arr[i][1]));
			}
		}
		
		System.out.println(dp[D]);
	}//end main
}
