import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int V;
		long cost;
		Edge(int V, long cost) {
			this.V = V;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Edge>[] edge = new ArrayList[N+1];
		for(int i=0; i<=N; i++) edge[i] = new ArrayList<Edge>();
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edge[A].add(new Edge(B,C));
			edge[B].add(new Edge(A,C));
		}
		
		Queue<Edge> que = new LinkedList<>();
		boolean[] check = new boolean[N+1];
		check[1] = true;
		que.offer(new Edge(1,0));
		long ans = 0;
		while(!que.isEmpty()) {
			Edge now = que.poll();
			if(now.cost>ans) ans = now.cost;
			for(int i=0; i<edge[now.V].size(); i++) {
				Edge next = edge[now.V].get(i);
				if(check[next.V]) continue;
				check[next.V] = true;
				que.offer(new Edge(next.V, now.cost+next.cost));
			}
		}
		System.out.println(ans);
	}//end main
}
