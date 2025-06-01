import java.util.*;
import java.io.*;

public class Main {
	public static class Edge implements Comparable<Edge>{
		int v;
		int c;
		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
		@Override
		public int compareTo(Edge e) {
			return e.c-this.c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Edge>[] list = new ArrayList[N+1];
		for(int i=0; i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] cost = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, Integer.MAX_VALUE));
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(now.v == end) {
				ans = now.c;
				break;
			}
			for(Edge edge : list[now.v]) {
				if(cost[edge.v]<now.c) {
					cost[edge.v] = Math.min(now.c, edge.c);
					pq.offer(new Edge(edge.v, cost[edge.v]));
				}
			}
		}//end while
		System.out.println(ans);
	}//end main
}
