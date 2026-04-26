import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = Arrays.copyOf(arr,N);
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(res[i] ==  arr[j]) {
                    arr[j] = -1;
                    sb.append(j).append(" ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }//end main
}