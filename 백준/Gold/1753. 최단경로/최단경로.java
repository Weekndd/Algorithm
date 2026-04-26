import java.io.*;
import java.util.*;

public class Main {
	static public class Node implements Comparable<Node>{
		int num, wei;
		public Node(int num, int wei) {
			this.num = num;
			this.wei = wei;
		}
		@Override
		public int compareTo(Node o) {
			return this.wei - o.wei;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		List<Node>[] nodeList = new ArrayList[V+1];
		int[] result = new int[V+1];
		for(int i=1; i<=V; i++) {
			nodeList[i] = new ArrayList<>();
			result[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			nodeList[start].add(new Node(end,wei));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		pq.add(new Node(K,0));
		result[K] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.num]) visited[now.num] = true;
			
			for(int i=0; i<nodeList[now.num].size(); i++) {
				Node next = nodeList[now.num].get(i);
				if(!visited[next.num] && result[next.num]>now.wei+next.wei) {
					result[next.num] = now.wei+next.wei;
					pq.offer(new Node(next.num, result[next.num]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(result[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(result[i]+"\n");
		}
		System.out.println(sb);
	}//end main
}