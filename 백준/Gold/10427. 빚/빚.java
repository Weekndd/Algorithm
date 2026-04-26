import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N+1];
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int[] prefix_sum = new int[N+1];
            for(int i=1; i<=N; i++) {
                prefix_sum[i] = prefix_sum[i-1]+arr[i];
            }
            //end prefix_sum
            int sum = 0;
            for(int i=2; i<=N; i++) {
                int min = Integer.MAX_VALUE;
                for(int j=i; j<=N; j++) {
                    int cost = (prefix_sum[j]-prefix_sum[j-1])*i-(prefix_sum[j]-prefix_sum[j-i]);
                    min = Math.min(cost,min);
                }
                sum += min;
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }//end main
}