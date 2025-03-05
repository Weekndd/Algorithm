import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dirR = new int[] {0,1};
		int[] dirC = new int[] {1,0};
		long[][] dp = new long[N+1][N+1];
		dp[1][1] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]==0) continue;
				int num = map[i][j];
				for(int d=0; d<2; d++) {
					int nr = i+(dirR[d]*num);
					int nc = j+(dirC[d]*num);
					if(nr>N || nr<0 || nc>N || nc<0) continue;
					dp[nr][nc] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N][N]);
	}//end main
}
