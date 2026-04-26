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
		int before = 0;
		for(int i=at; i<N; i++) {
			if(visited[i]) {
				continue;
			}
			if(before == arr[i]) {
				continue;
			}
			depthArr[depth] = arr[i]; 
			visited[i] = true;
			dfs(depth+1,i);
			visited[i] = false;
			before = arr[i];
		}
	}//end dfs
}