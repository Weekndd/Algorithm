import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			dp = new long[N+1][M+1];
			for(int i=0; i<=M; i++) {
				dp[0][i] = 1;
			}
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					dp[i][j] = dp[i-1][j/2] + dp[i][j-1]; 
				}
			}
			sb.append(dp[N][M] + "\n");
		}
		System.out.println(sb);
	} //end main
}

