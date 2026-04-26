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
        int left = 0;
        int right = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>left) left = arr[i];
            right += arr[i];
        }
        //end input

        while(left<=right) {
            int mid = left+(right-left)/2;

            int sum = 0;
            int cnt = 0;

            for(int i=0; i<N; i++) {
                if(cnt>M) break;
                if(sum+arr[i]>mid) {
                    sum=0;
                    cnt++;
                }
                sum += arr[i];
            }
            if(sum!=0) cnt++;
            //right뒤쪽에 있는 값들은 전부 정답이라 할 수 있기에 최소값을 구하려면 같은 경우에도 right 뒤쪽으로 옮겨줘야한다.
            if(cnt<=M) right = mid-1;
            else left = mid+1;
        }
        System.out.println(left);
    }//end main
}
