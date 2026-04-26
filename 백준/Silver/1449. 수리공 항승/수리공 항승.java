import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int ans = 0;
        int pre = arr[0];
        
        for(int i=1; i<N; i++) {
            int dis = arr[i]-pre;
            if(dis>=L-1) {
                if (dis>L-1) pre = arr[i];
                else pre = ++i<N ? arr[i] : 0;
                ans++;
            }
        }
        System.out.println(pre==0?ans:++ans);
    }//end main
}