import java.util.*;
import java.io.*;

public class Main { //백준_앱
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memories = new int [N+1];
        int[] costs = new int [N+1];
        
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int maxValue = 0;
        for(int i=1; i<=N; i++) {
        	memories[i] = Integer.parseInt(st.nextToken());
        	costs[i] = Integer.parseInt(st2.nextToken());
        	maxValue += costs[i];
        }
        //end input
        
        int ans = Integer.MAX_VALUE;
        int[][]dp = new int[N+1][maxValue+1];
        for(int i=1; i<=N; i++) {
        	for(int j=0; j<=maxValue; j++) {
        		if(j<costs[i]) {
        			dp[i][j] = dp[i-1][j];
        		}
        		else {
        			dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i]]+memories[i]);
        		}
        		if(dp[i][j]>=M) {
        			ans = Math.min(ans, j);
        		}
        	}
        }
        System.out.println(ans);
    }//end main
}