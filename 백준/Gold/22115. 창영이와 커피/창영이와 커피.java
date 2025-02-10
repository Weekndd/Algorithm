import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] dp = new int[K+1];
    	Arrays.fill(dp,Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i=0; i<N; i++) {
    		int coffee = arr[i];
    		for(int j=K; j>=0; j--) {
    			if(j-coffee>=0 && dp[j-coffee] != Integer.MAX_VALUE) {
    				dp[j] = Math.min(dp[j], dp[j-coffee] + 1);
    			}
    		}
    	}
    	System.out.println(dp[K]==Integer.MAX_VALUE ? -1 : dp[K]);
    	
    }//end main
}