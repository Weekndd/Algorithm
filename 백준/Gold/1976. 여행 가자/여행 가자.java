import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	static int[] parent;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시의 수
		int M = Integer.parseInt(br.readLine()); // 여행 할 도시 수
		
		int[][] map = new int[N+1][N+1];
		
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					union(i,j);
				}
			}
		}
		//end input
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int pre = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(find(pre) != find(cur)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}//end Main	
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			if(a<b) {
				parent[b] = a;
			}
			else {
				parent[a] =b;
			}
		}
	}
	
	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		else {
			return parent[a] = find(parent[a]);
		}
	}
}