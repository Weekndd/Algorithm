import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());
		long cnt = 0;
		for(int i=0; i<N; i++) {
			long sum = 0;
			for(int j=i; j<N; j++) {
				sum += arr[j];
				if(sum>K) {
					cnt += N-j;
					break;
				}
			}
		}
		System.out.println(cnt);
	}//end main
}