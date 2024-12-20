import java.util.*;
import java.io.*;

public class Main {
	static int V, target;
	static long max;
	static List<int[]>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		arr = new ArrayList[V+1];
		for(int i=1; i<=V; i++) arr[i] = new ArrayList<>();
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				arr[idx].add(new int[] {num, cost});
				arr[num].add(new int[] {idx, cost});
			}
		}//end input
		
		//임의의 노드에서 가장 먼 노드 찾기
		visited = new boolean[V+1];
		for(int i=1; i<=V; i++) {
			if(arr[i].size() == 0) continue;
			dfs(arr[i].get(0)[0], 0);
			break;
		}
		//가장 먼 노드에서 다시 DFS
		visited = new boolean[V+1];
		dfs(target, 0);
		System.out.println(max);
	}//end main
	
	public static void dfs(int idx, long sum) {
		visited[idx] = true;
		
		for(int i=0; i<arr[idx].size(); i++) {
			if(visited[arr[idx].get(i)[0]]) continue;
			long temp = arr[idx].get(i)[1]+sum;
			dfs(arr[idx].get(i)[0],temp);
		}
		if(sum>max) {
			max = sum;
			target = idx;
		}
	}
}
