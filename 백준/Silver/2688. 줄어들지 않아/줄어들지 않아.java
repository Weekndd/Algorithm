import java.io.*;
import java.util.*;

public class Main {
	static int N,cnt;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	long[][] dp = new long[65][10];
		for(int i=10; i>0; i--) {
			dp[1][10-i] = i; 
		}
		
		for(int i=2; i<65; i++) {
			for(int j=0; j<10; j++) {
				long sum = 0;
				for(int k=j; k<10; k++) {
					sum += dp[i-1][k];
				}
				dp[i][j] = sum; 
			}
		}
    	for(int t=0; t<T; t++) {
    		N = Integer.parseInt(br.readLine());
    		sb.append(dp[N][0]+"\n");
    	}
    	System.out.println(sb);
    }//end main
    
}