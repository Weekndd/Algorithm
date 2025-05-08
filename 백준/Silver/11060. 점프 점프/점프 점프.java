import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int MAX = 1001;
    	int[] arr = new int[N+1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=1; i<=N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int[] dp = new int[N+1];
    	Arrays.fill(dp,MAX);
    	dp[1] = 0;
    	for(int i=1; i<=N; i++) {
    		int jump = arr[i];
    		for(int j=1; j<=jump; j++) {
    			if(i+j > N) continue;
    			dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
    		}
    	}
    	System.out.println(dp[N]==MAX ? -1 : dp[N]);
    }//end main
}