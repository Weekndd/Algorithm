import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }//end input
        for(int i=0; i<N; i++) {
            dp[i] = arr[i];
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j] && dp[i]<arr[i]+dp[j]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }//end i for
        int max = 0;
        for(int i : dp) {
            max = i > max ? i : max;
        }
        System.out.println(max);
    }//end main
}