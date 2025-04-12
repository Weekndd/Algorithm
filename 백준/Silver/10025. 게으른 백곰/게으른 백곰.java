import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int ice = Integer.parseInt(st.nextToken());
        	int col = Integer.parseInt(st.nextToken());
        	arr[col] = ice;
        }
        
       int max = 0;
       int sum = 0;
       for(int i=0; i<=1000000; i++) {
    	   if(i-(K*2+1)>=0) sum -= arr[i-(K*2+1)];
    	   sum += arr[i];
    	   max = Math.max(max,sum);
       }
       System.out.println(max);
    }//end
}