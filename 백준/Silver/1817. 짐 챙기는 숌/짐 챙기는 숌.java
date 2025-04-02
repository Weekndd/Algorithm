import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N==0) {
        	System.out.println(0); 
        	return;
        }
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
        	if(sum+arr[i]>M) {
        		cnt++;
        		sum = arr[i];
        	}
        	else sum += arr[i];
        }
        if(sum>0) cnt++;
        System.out.println(cnt);
    }
}