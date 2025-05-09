import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	int max = 0;
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		max = Math.max(max,arr[i]);
    	}
    	
    	int left = 0;
    	int right = max;
    	int ans = max;
    	while(left<=right) {
    		int cnt = 0;
    		boolean flag = false;
    		int mid = left+(right-left)/2;
    		for(int i=0; i<N; i++) {
    			if(arr[i]>mid) cnt++;
    			else cnt = 0;
    			if(cnt>=K) {
    				flag = true;
    				break;
    			}
    		}//end for
    		if(flag) {
    			left = mid+1;
    		} else {
    			ans = Math.min(ans, mid);
    			right = mid-1;
    		}
    	}//end while
    	System.out.println(ans);
    }//end main
}