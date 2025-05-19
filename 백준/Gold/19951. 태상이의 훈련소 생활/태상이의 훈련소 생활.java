import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //연병장 크기
		int M = Integer.parseInt(st.nextToken()); //조교 수
		int[] ground = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			ground[i] = Integer.parseInt(st.nextToken());
		}
		int[] prefixSum = new int[N+2];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int work = Integer.parseInt(st.nextToken());
			prefixSum[start] += work;
			prefixSum[end+1] -= work;
		}
		StringBuilder sb = new StringBuilder();
		int pre = 0;
		for(int i=1; i<=N; i++) {
			pre += prefixSum[i];
			sb.append((ground[i]+pre)+" ");
		}
		System.out.println(sb);
	}//end main
}
