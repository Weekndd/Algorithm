import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int  N = Integer.parseInt(st.nextToken());
    	int  X = Integer.parseInt(st.nextToken());
    	
    	int[][] pipes = new int[N+1][2];
    	for(int i=1; i<=N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int L = Integer.parseInt(st.nextToken());
    		int C = Integer.parseInt(st.nextToken());
    		pipes[i][0] = L;
    		pipes[i][1] = C;
    	}
    	
    	int[] dp = new int[X+1];
    	dp[0] = 1;
    	for(int[] pipe : pipes) {
    		int L = pipe[0];
    		int C = pipe[1];
    		for(int j=X; j>=L; j--) {
    			for(int k=1; k<=C && j>=L*k; k++) {
    				dp[j] += dp[j-L*k];
    			}
    		}
    	}
    	System.out.println(dp[X]);
    }//end main
}