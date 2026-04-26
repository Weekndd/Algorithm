import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	
	static int V;
	static int LINE;
	static int START;
	static int[][] arr;
	static boolean[] visited;
	static StringBuilder sb  = new StringBuilder();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		LINE = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(st.nextToken());
		arr = new int[V+1][V+1];
		
		for(int i=1; i<=LINE; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
 		}
		visited = new boolean[V+1];
		dfs(START);
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}//end main
	
	//BFS
	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		visited = new boolean[V+1];
		que.offer(START);
		visited[START] = true;
		sb.append(START+" ");
		
		while(!que.isEmpty()) {
			int start = que.poll();
			for(int i=1; i<=V; i++) {
				if(arr[start][i] == 1 && visited[i]!=true) {
					que.offer(i);
					visited[i] = true;
					sb.append(i+" ");
				}
			}//end for
			
		}//end while
	}//end BFS()
	
	
	//DFS
	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start+" ");
		
		for(int i=1; i<=V; i++) {
			if(arr[start][i]==1 && visited[i]!=true) {
				dfs(i);
			}
		}
		
	}//end DFS()
	
}