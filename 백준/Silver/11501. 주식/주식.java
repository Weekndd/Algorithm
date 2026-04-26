import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int M = Integer.parseInt(br.readLine());
			int[] arr = new int[M];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num;
			}//end input
			
			long sum = 0;
			int max = arr[M-1];
			
			for(int j=M-2; j>=0; j--) {
				if(arr[j]<max) {
					sum += max - arr[j];
				}
				else {
					max = arr[j];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}//end main
}