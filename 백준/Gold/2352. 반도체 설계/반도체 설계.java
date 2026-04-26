import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] LIS = new int[N];
        int len = 1;
        LIS[0]=arr[0];

        for(int i=0; i<N; i++) {
            int target = arr[i];
            if(LIS[len-1]<arr[i]) {
                LIS[len] = arr[i];
                len++;
                continue;
            }
            int left = 0;
            int right = len-1;
            while(left<=right) {
                int mid = left+(right-left)/2;
                if(LIS[mid]<target) left = mid+1;
                else right = mid-1;
            }
            LIS[left] = target;
        }
        System.out.println(len);
    }//end main
}