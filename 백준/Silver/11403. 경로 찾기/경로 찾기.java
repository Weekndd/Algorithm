import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}//end input
		int[][] res = new int[N][N];
		for(int i=0; i<N; i++) {
			boolean[] visited = new boolean[N];
			Queue<Integer> que = new LinkedList<>();
			que.offer(i);
			
			while(!que.isEmpty()) {
				int vertex = que.poll();
				for(int j=0; j<N; j++) {
					if(!visited[j] && map[vertex][j]==1) {
						res[i][j] = 1;
						que.offer(j);
						visited[j] = true;
					}
				}
			}//end while
		}
		for(int i[]:res) {
			for(int j:i) {
				sb.append(j+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}//end main
}