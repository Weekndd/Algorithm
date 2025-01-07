import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			min = Math.min(min,arr[i]);
			max = Math.max(max,arr[i]);
		}
		
		int left = min;
		int right = max+K;
		int res = 0;
		while(left<=right) {
			int mid = left+(right-left)/2;
			long total = 0;
			for(int i=0; i<N; i++) {
				if(mid>=arr[i]) total += mid-arr[i];
				if(total>K) break;
			}
			if(total>K) {
				right = mid-1;
			}
			else {
				res = mid;
				left = mid+1;
			}
		}//end while
		System.out.println(res);
	}//end main
}
