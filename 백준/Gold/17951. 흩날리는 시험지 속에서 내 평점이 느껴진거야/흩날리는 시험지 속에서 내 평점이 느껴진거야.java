import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int total = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(arr[i], min);
			total += arr[i];
		}
		
		int left = min;
		int right = total;
		int ans = 0;
		while(left<=right) {
			int mid = left+(right-left)/2;
			int sum = 0;
			int group = 0;
			
			for(int i=0; i<N; i++) {
				sum += arr[i];
				if(sum>=mid) {
					group++;
					sum = 0;
				}
			}
			
			if(group>=M) {
				ans = Math.max(ans, mid);
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		System.out.println(ans);
	}//end main
}
