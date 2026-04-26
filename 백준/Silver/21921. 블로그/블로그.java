import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N];
        sum[0] = arr[0];
        //누적합
        for(int i=1; i<N; i++) {
            sum[i] = sum[i-1]+arr[i];
        }

        int max = sum[M-1];
        int cnt = 1;
        for(int i=M;i<N; i++) {
            if(max==sum[i]-sum[i-M]) cnt++;
            if(max<sum[i]-sum[i-M]) {
                cnt = 1;
                max = sum[i]-sum[i-M];
            }
        }
        if(max==0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}