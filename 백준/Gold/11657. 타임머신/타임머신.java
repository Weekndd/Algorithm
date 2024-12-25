import java.util.*;
import java.io.*;

public class Main {
	public static class Node implements Comparable<Node>{
		int S,E;
		long cost;
		public Node(int S, int E, long cost) {
			this.S = S;
			this.E = E;
			this.cost = cost;
		}
		public int compareTo(Node o1) {
			return (int)(this.cost - o1.cost);
		}
	}
	
	static Node[] arr;
	static int N,M;
	static long INF, dis[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Node[M+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[i]=new Node(s,e,c);
		}
		StringBuilder sb = new StringBuilder();
		INF = Long.MAX_VALUE;
		dis = new long[N+1];
		Arrays.fill(dis,INF);
		dis[1] = 0;
		
		if(bellmanFord(1)) {
			sb.append(-1+"\n");
		}
		else {
			for(int i=2; i<=N; i++) {
				if(dis[i]==INF) sb.append(-1+"\n");
				else sb.append(dis[i]+"\n");
			}
		}
			
		System.out.println(sb);
	}//end main
	public static boolean bellmanFord(int start) {
		boolean update = false;
		
		for(int i=1; i<=N-1; i++) {
			update = false;
			for(int j=0; j<M; j++) {
				Node node = arr[j];
				if(dis[node.S]==INF || dis[node.E]<=dis[node.S]+node.cost) continue;
				dis[node.E] = dis[node.S] + node.cost; 
				update = true;
			}
			if(!update) break;
		}
		if(update) {
			for(int j=0; j<M; j++) {
				Node node = arr[j];
				if(dis[node.S]==INF || dis[node.E]<=dis[node.S]+node.cost) continue;
				return true;
			}
		}
		return false;
	}
}
