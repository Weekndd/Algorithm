import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[][] arr = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			arr[i][0] = Integer.parseInt(st1.nextToken());
			arr[i][1] = Integer.parseInt(st2.nextToken());
		}
		int[] dp = new int[101];
		for(int[] a : arr) {
			int hp = a[0];
			int mp = a[1];
			for(int j=100; j>=hp; j--) {
				dp[j] = Math.max(dp[j-hp]+mp, dp[j]);
			}
		}
		int ans = 0;
		for(int i=1; i<100; i++) {
			ans = Math.max(dp[i],ans);
		}
		System.out.println(ans);
	}//end main
}
