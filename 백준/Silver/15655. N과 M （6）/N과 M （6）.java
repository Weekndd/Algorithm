import java.io.*;
import java.util.*;

public class Main {
	
	private static int M;
	private static int N;
	private static int[] numArr;
	private static int[] depthArr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		numArr = new int[N];
		depthArr = new int[M];
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		//end input
		dfs(0,0);
		System.out.println(sb);
		
	}//end main
	private static void dfs(int depth, int at) {
		if(depth == M) {
			for(int i : depthArr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=at; i<N; i++) {
			depthArr[depth] = numArr[i];
			dfs(depth+1, i+1);
		}
		return;
	}//end dfs
	
}