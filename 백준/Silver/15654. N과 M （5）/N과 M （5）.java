import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] arr;
	public static int[] numArr;
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
		numArr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}//end input
		Arrays.sort(numArr);
		dfs(0);
		System.out.println(sb);
		
	}//end main
	private static void dfs(int depth) {
		if(depth == M) {
			for(int i : arr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<numArr.length; i++) {
			if(visited[i]) {
				continue;
			}
			arr[depth] = numArr[i];
			visited[i] = true;
			dfs(depth+1);
			visited[i] = false;
		}
		
	}//end dfs
}