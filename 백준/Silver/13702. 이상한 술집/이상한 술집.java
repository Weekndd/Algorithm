import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	max = Math.max(max, arr[i]);
        }
        
        int left = 1;
        int right = max;
        int ans = 0;
        while(left<=right) {
        	int mid = left+(right-left)/2;
        	
        	int cnt = 0;
        	for(int i=0; i<N; i++) {
        		cnt += arr[i]/mid;
        	}
        	if(cnt>=K) {
        		ans = mid;
        		left = mid+1;
        	}
        	else {
        		right = mid-1;
        	}
        }//end while
        System.out.println(ans);
    }
}