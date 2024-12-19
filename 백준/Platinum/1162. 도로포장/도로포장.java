import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static class Node {
		int S,E,cnt;
		long W;
		public Node(int S, int E, long W, int cnt) {
			this.S = S;
			this.E = E;
			this.W = W;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N+1][K+1];
		List<Node>[] way = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			way[i] = new ArrayList<>();
			Arrays.fill(dp[i],Long.MAX_VALUE);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o1-> o1.W));
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			way[s].add(new Node(s,e,w,0));
			way[e].add(new Node(e,s,w,0));
		}
		pq.add(new Node(1,1,0,0));
		dp[1][0] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.E==N) {
				System.out.println(now.W);
				return;
			}
			if(now.W > dp[now.E][now.cnt]) continue;
			for(Node next : way[now.E]) {
				long nextCost = now.W+next.W;
				if(nextCost < dp[next.E][now.cnt]) {
					dp[next.E][now.cnt] = nextCost;
					pq.offer(new Node(next.S, next.E, nextCost, now.cnt));
				}
				if(now.cnt<K && now.W<dp[next.E][now.cnt+1]) {
					dp[next.E][now.cnt+1] = now.W;
					pq.offer(new Node(next.S, next.E, now.W, now.cnt+1));
				}
			}
		}//end while
	}//end main
}
