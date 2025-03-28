import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		
		int cnt = 0;
		while(left<right) {
			int sum = arr[left] + arr[right];
			if(sum<=K) {
				cnt++;
				left++;
				right--;
			}
			else if(sum>K) {
				right--;
			}
		}
		System.out.println(cnt);
	}//end main
}
