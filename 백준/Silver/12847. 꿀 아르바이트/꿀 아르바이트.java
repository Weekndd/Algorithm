import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] prefixSum = new long[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(i==0) prefixSum[i] = num;
			else prefixSum[i] = prefixSum[i-1] + num;
		}
		long max = prefixSum[M-1];
		for(int i=M; i<N; i++) {
			max = max > prefixSum[i] - prefixSum[i-M] ? max : prefixSum[i] - prefixSum[i-M];
		}
		System.out.println(max);
	}//end main
}
