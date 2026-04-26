import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0, right = N-1;

        int ans = 0;
        while(left<right) {
            int num = arr[left] + arr[right];
            if(num==X) {
                ans++;
                left++;
            }
            else if(num<X) left++;
            else right--;
        }
        System.out.println(ans);
    }//end main
}