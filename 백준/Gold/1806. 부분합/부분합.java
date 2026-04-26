import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //end input

        int left = 0, right = 1;
        int length = Integer.MAX_VALUE;
        int sum = arr[left] + arr[right];

        if(arr[left]==S || arr[right]==S) {
            System.out.println(1);
            return;
        }

        while(left<=right) {
            if(sum>=S) {
                length = Math.min(length, right-left+1);
                sum-=arr[left++];
            }
            else if(sum<S && right+1<N) {
                sum+=arr[++right];
            }
            else break;
        }//end while
        System.out.println(length==Integer.MAX_VALUE ? 0 : length);
    }//end main
}