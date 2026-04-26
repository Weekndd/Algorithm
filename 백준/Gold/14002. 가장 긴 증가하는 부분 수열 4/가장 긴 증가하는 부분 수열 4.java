import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            dp[i] = 1;
            for(int j=1; j<=i; j++) {
                if(arr[i]>arr[j] && dp[i]<=dp[j]) {
                    dp[i]=dp[j]+1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int idx = 0;
        for(int i=1; i<=N; i++) {
            if(max<dp[i]) {
                max = dp[i];
                idx = i;
            }
        }
        int temp = max;
        List<Integer> list = new ArrayList();
        for(int i=idx; i>0; i--) {
            if(temp==0) break;
            if(dp[i]==temp) {
                list.add(arr[i]);
                temp--;
            }
        }
        Collections.sort(list);
        sb.append(max+"\n");
        for(int i : list) sb.append(i+" ");
        System.out.println(sb);
    }//end main
}
