import java.util.*;
import java.io.*;

public class Main {
	public static class Node implements Comparable<Node>{
		int N, cost;
		public Node(int N, int cost) {
			this.N = N;
			this.cost = cost;
		}
		public int compareTo(Node o1) {
			return this.cost - o1.cost;
		}
	}
	static int V;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		for(int i=1; i<=V; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e,c));
			list[e].add(new Node(s,c));
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int disA = 0;
		int res = dijikstra(1, A);
		if(res == -1) return;
		disA += res;
		res = dijikstra(A, B);
		if(res == -1) return;
		disA += res;
		res = dijikstra(B, V);
		if(res == -1) return;
		disA += res;
		
		int disB = 0;
		res = dijikstra(1, B);
		if(res == -1) return;
		disB += res;
		res = dijikstra(B, A);
		if(res == -1) return;
		disB += res;
		res = dijikstra(A, V);
		if(res == -1) return;
		disB += res;
		
		
		System.out.println(Math.min(disA, disB));
	}//end main
	
	public static int dijikstra(int start, int target) {
		int INF = 100000000;
		int[] dis = new int[V+1];
		Arrays.fill(dis, INF);
		dis[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dis[now.N] < now.cost) continue;
			if(now.N == target) {
				return now.cost;
			}
			for(Node next : list[now.N]) {
				if(dis[next.N] < now.cost + next.cost) continue;
				dis[next.N] = now.cost + next.cost;
				pq.offer(new Node(next.N, now.cost + next.cost));
			}
		}
		System.out.println(-1);
		return -1;
	}
}
