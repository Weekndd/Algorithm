import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] temp = new int[N-1];
        for(int i=1; i<N; i++) {
        	temp[i-1] = arr[i]-arr[i-1];
        }
        Arrays.sort(temp);
        int ans = 0;
        for(int i=0; i<(N-1)-(K-1); i++) {
        	ans+=temp[i];
        }
        System.out.println(ans);
    }//end main
}