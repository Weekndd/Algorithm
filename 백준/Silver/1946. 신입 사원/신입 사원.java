import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] arr = new int[N+1];
        	for(int j=0; j<N; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		int A = Integer.parseInt(st.nextToken());
        		int B = Integer.parseInt(st.nextToken());
        		arr[A] = B;
        	}
        	int min = arr[1];
        	int cnt = 1;
        	for(int j=2; j<=N; j++) {
        		if(min > arr[j]) {
        			min = arr[j];
        			cnt++;
        		}
        	}
        	sb.append(cnt+"\n");
        }//end Test
    	System.out.println(sb);
    }
}