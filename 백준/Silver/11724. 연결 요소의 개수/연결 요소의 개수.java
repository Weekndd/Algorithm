import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int V = Integer.parseInt(st.nextToken());
		int LINE = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[V+1][V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=0; i<LINE; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		int count = 0;
		
		for(int i=1; i<=V; i++) {
			if(visited[i]!=true) {
				Queue<Integer> que = new LinkedList<Integer>();
				que.offer(i);
				
				while(!que.isEmpty()) {
					int num = que.poll();
					
					for(int j=1; j<=V; j++) {
						if(arr[num][j]==1 && visited[j]!=true) {
							visited[j] = true;
							que.offer(j);
						}
					}
					
				}//end while
				count++;
			}
			
		}//end i for 
		
		System.out.println(count);
	}	
}