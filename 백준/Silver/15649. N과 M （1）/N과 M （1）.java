import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static int N;
	public static int M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		dfs(0);
		System.out.println(sb);
		
	}//end main
	private static void dfs(int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
 				dfs(depth+1);
				visited[i] = false;
			}
			
		}
		return;
	}//end dfs
}