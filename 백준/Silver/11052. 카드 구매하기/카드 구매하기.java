import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) {
        	int price = arr[i];
        	for(int j=i; j<=N; j++) {
        		dp[j] = Math.max(dp[j], dp[j-i]+price);
        	}
        }
        System.out.println(dp[N]);
    }//end main
}