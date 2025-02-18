import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[K+1][2];
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[]dp = new int[N+1];
		for(int i=1; i<=K; i++) {
			int im = arr[i][0];
			int time = arr[i][1];
			for(int j=N; j>=time; j--) {
				dp[j] = Math.max(dp[j],dp[j-time]+im);
			}
		}
		System.out.println(dp[N]);
	}//end main
}
