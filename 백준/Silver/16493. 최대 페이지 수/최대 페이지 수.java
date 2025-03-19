import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[M+1][2];
        for(int i=1; i<=M; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];
        for(int i=1; i<=M; i++) {
        	int[] book = arr[i];
        	int days = book[0]; 
        	int pages = book[1]; 
        	for(int j=N; j>=days; j--) {
            	dp[j] = Math.max(dp[j], dp[j-days]+pages);
        	}
        }
        System.out.println(dp[N]);
    }//end main
}