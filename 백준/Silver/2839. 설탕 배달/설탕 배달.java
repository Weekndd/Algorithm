import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            if(i<3) {
                dp[i] = -1;
            }
            else if(i%5==0) {
                dp[i] = dp[i-5]+1;
            }
            else if(i%3==0) {
                dp[i] = dp[i-3]+1;
            }
            else {
                if(i-5<=0) dp[i] = dp[i-3];
                else dp[i] = Math.min(dp[i-5],dp[i-3]);
                if(dp[i]!=-1) dp[i]++;
            }
        }
        System.out.println(dp[N]);

    }//end main
}