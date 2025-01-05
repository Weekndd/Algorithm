import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int E, COST, STOPOVER;
		public Node(int E, int COST, int STOPOVER) {
			this.E = E;
			this.COST = COST;
			this.STOPOVER = STOPOVER;
		}
		public int compareTo(Node o1) {
			if(this.COST == o1.COST) {
				return this.STOPOVER - o1.STOPOVER;
			}
			return this.COST - o1.COST;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] arr = new ArrayList[N+1];
		for(int i=0; i<=N; i++) arr[i] = new ArrayList();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int basicCost = Integer.parseInt(st.nextToken());
			int extraCost = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			if(time<=10) arr[start].add(new Node(end, basicCost,0));
			else arr[start].add(new Node(end, (time-10)*extraCost + basicCost,0));
		}
		PriorityQueue<Node> pq = new PriorityQueue();
		int[] dis = new int[N+1];
		int INF = 1000000000;
		Arrays.fill(dis,INF);
		dis[1] = 0;
		pq.offer(new Node(1,0,1));
		
		int stopover = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.E == N) {
				stopover = now.STOPOVER; 
				break;
			}
			for(int i=0; i<arr[now.E].size(); i++) {
				Node next = arr[now.E].get(i);
				int nextCost = now.COST+next.COST;
				if(dis[next.E]<nextCost) continue;
				dis[next.E] = nextCost;
				pq.offer(new Node(next.E, nextCost, now.STOPOVER+1));
			}
		}
		if(dis[N]==INF) System.out.println("It is not a great way.");
		else System.out.println(dis[N]+" "+stopover);
	}//end main
}
