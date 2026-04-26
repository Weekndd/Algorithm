import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i<L) {
                sum += arr[i];
                if(129<=sum && sum<=138) cnt++;
            }
        }
        for(int i=L; i<N; i++) {
            sum -= arr[i-L];
            sum += arr[i];
            if(129<=sum && sum<=138) cnt++;
        }
        System.out.println(cnt);
    }//end main
}