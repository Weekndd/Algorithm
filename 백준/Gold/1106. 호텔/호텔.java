import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int  C = Integer.parseInt(st.nextToken());
    	int  N = Integer.parseInt(st.nextToken());
    	
    	int[][] arr = new int[N+1][2];
    	for(int i=1; i<=N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int cost = Integer.parseInt(st.nextToken());
    		int customer = Integer.parseInt(st.nextToken());
    		arr[i][0] = cost;
    		arr[i][1] = customer;
    	}
    	int[] dp = new int[C+101];
    	Arrays.fill(dp,1000000000);
    	dp[0] = 0;
    	for(int i=1; i<=N; i++) {
    		int[] city = arr[i];
    		int cost = city[0];
    		int customer = city[1];
    		for(int j=customer; j<=C+100; j++) {
    			dp[j] = Math.min(dp[j],dp[j-customer]+cost);
    		}
    	}
    	int ans =Integer.MAX_VALUE;
    	for(int i=C; i<=C+100; i++) {
    		ans = Math.min(ans,dp[i]);
    	}
    	System.out.println(ans);
    }//end main
}