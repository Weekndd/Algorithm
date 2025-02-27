import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[301][301];
		int[][] candies = new int[N][2]; 
		int er = 0;
		int ec = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			candies[i][0] = r;
			candies[i][1] = c;
			er = Math.max(er,r);
			ec = Math.max(ec,c);
		}
		int[][] dp = new int[er+1][ec+1];
		for(int[] candy : candies) {
			int r = candy[0];
			int c = candy[1];
			dp[r][c] = r+c>M ? 0 : M-(r+c);
		}
		
		int max = 0;
		for(int i=1; i<=er; i++) {
			for(int j=1; j<=ec; j++) {
				if(map[i][j]==1) {
					if(i+j>M) continue;
					int dis = M-(i+j);
					dp[i][j] = Math.max(dp[i][j],Math.max(dp[i][j-1],dp[i-1][j])+dis);
				}
				else {
					dp[i][j] = Math.max(dp[i][j],Math.max(dp[i][j-1],dp[i-1][j]));
				}
				max = Math.max(dp[i][j],max);
			}
		}
		System.out.println(max);
    }
}