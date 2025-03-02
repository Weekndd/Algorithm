import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		long[][][] dp = new long[N+1][N+1][3];
		dp[1][2][0] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=3; j<=N; j++) {
				if(arr[i][j]==1) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]; //가로
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]; //세로
				
				if(arr[i-1][j]==1 || arr[i][j-1]==1) continue;
				dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]; //대각
				
			}
		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }//end main
}