import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	static int Node;
	static int Line;
	static int[][] map;
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node = Integer.parseInt(br.readLine());
		Line = Integer.parseInt(br.readLine());
		
		map = new int [Node+1][Node+1];
		visited = new boolean[Node+1];
		count = 0;
		
		for(int i=0; i<Line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(count-1);
		
	}
	public static void dfs(int start) {
		
		visited[start] = true;
		count++;
			for(int i=0; i<=Node; i++) {
				if(map[start][i]==1 && visited[i]!=true) {
					dfs(i);
				}
			}
		
	}
	
}