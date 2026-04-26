import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R, X, ans, arr[];
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //end input
        check = new boolean[N];
        combination(0, 0,0,Integer.MAX_VALUE, 0);
        System.out.println(ans);


    }//end main
    public static void combination(int cnt, int idx, int sum, int min, int max) {
        if(cnt>=2 && (L<=sum && sum<=R) && max-min>=X) {
            ans++;
        }
        for(int i=idx; i<N; i++) {
            combination(cnt+1, i+1, sum+arr[i], Math.min(min,arr[i]), Math.max(max,arr[i]));
        }
    }//end
}