import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int ver;
		int line;
		public Node(int ver, int line) {
			this.ver = ver;
			this.line = line;
		}
		@Override
		public int compareTo(Node o) {
			return line-o.line;
		}
	}
	static int N,M,R,ans,max;
	static int[] item;
	static int[] dist;
	static boolean[] visited;
	static List<List<Node>> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //노드 수
		M = Integer.parseInt(st.nextToken()); //수색범위
		R = Integer.parseInt(st.nextToken()); //간선의 수
		
		st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		item = new int[N+1];
		for(int i=1; i<=N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Node>());
		}//리스트 초기화
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken()); 
			int line = Integer.parseInt(st.nextToken()); 
			list.get(A).add(new Node(B,line));
			list.get(B).add(new Node(A,line));
		}
		//end input
		
		ans = 0;
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, dijkstra(i));
		}
		System.out.println(ans);
	}//end main
	
	static public int dijkstra(int idx) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(idx,0));
		dist[idx] = 0;
		
		while(!pq.isEmpty()) { 
			Node nowNode = pq.poll();
			
			if(!visited[nowNode.ver]) {
				visited[nowNode.ver] = true;
				
				for(Node nextNode : list.get(nowNode.ver)) {
//					if(!visited[nextNode.ver]) {
					if(!visited[nextNode.ver] && dist[nextNode.ver] > dist[nowNode.ver]+nextNode.line) {
//						dist[nextNode.ver] = Math.min(dist[nextNode.ver],dist[nowNode.ver]+nextNode.line);
						dist[nextNode.ver] = dist[nowNode.ver]+nextNode.line;
						pq.offer(new Node(nextNode.ver, dist[nextNode.ver]));
					}
				}
			}
		}//end while
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i]<=M) {
				max += item[i];
			}
		}
		return max;
	}//end dijkstra
}
