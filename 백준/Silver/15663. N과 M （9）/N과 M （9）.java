import java.io.*;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	private static boolean[] visited;
	private static int[] depthArr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		depthArr = new int[M];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}//end main
	
	private static void dfs(int depth) {
		if(depth == M) {
			for(int i :depthArr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		int num = 0;
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				continue;
			}
			if(num != arr[i]) {
			depthArr[depth] = arr[i];
			visited[i] = true;
			num = arr[i];
			dfs(depth+1);
			visited[i] = false;
			}
		}
		return;
	}//end dfs
}