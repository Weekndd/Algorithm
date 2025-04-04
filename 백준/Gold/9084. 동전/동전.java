import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for(int i=0; i<N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int money = Integer.parseInt(br.readLine());
            int[] dp = new int[money+1];
            for(int i=0; i<N; i++) {
                int coin = coins[i];
                for(int j=1; j<=money; j++) {
                    if(j-coin>0) {
                        dp[j] = dp[j]+dp[j-coin];
                    }
                    else if(j-coin==0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[money]+"\n");
        }
        System.out.println(sb);
    }//end main
}