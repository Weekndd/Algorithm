import java.util.*;
import java.io.*;
public class Main { //가방 문제 다시풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }//end input

        int start = 0;
        int end = 0;
        long sum = 0;
        int count = 0;
        while(start < N) {
            if(sum == M) {
                sum -= arr[start];
                start++;
                count++;
            }
            else if(sum>M || end >=N) {
                sum -= arr[start];
                start++;
            }
            else if(sum<M) {
                sum += arr[end];
                end++;
            }
        }
        System.out.println(count);
    }//end main
}