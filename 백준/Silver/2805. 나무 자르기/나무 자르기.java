import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for(int i=0; i<N; i++) {
        	long tree = Long.parseLong(st.nextToken());
        	arr[i] = tree;
        	max = Math.max(max,arr[i]);
        }
        
        long left = 0;
        long right = max;
        long ans = 0;
        while(left<=right) {
        	long mid = left+(right-left)/2;
        	long total = 0;
        	for(int i=0; i<N; i++) {
        		if(mid>=arr[i]) continue;
        		total += arr[i]-mid;
        	}
        	if(total<M) {
        		right = mid-1;
        	}
        	else {
        		ans = mid;
        		left = mid+1;
        	}
        }
        System.out.println(ans);
    }//end main
}