import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] LIS = new int[N];
        int length = 1;
        LIS[0] = arr[0];
        for(int i=1; i<N; i++) {
            int target = arr[i];
            if(LIS[length-1]<target) {
                LIS[length] = target;
                length++;
                continue;
            }
            int left = 0;
            int right = length-1;
            while(left<=right) {
                int mid = left+(right-left)/2;
                if(LIS[mid]<target) left = mid+1;
                else right = mid-1;
            }
            LIS[left] = target;
        }
        System.out.println(length);
    }//end main
}
