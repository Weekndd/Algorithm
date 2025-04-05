import java.io.*;
import java.util.*;

public class Main {
	static int V,E,P;
	static List<Edge>[] edges;
	static class Edge implements Comparable<Edge>{
		int vertex, cost;
		Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		public int compareTo(Edge o1) { 
			return this.cost - o1.cost;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        edges = new ArrayList[V+1];
        for(int i=1; i<=V; i++) edges[i] = new ArrayList<>();
        
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	edges[a].add(new Edge(b,c));
        	edges[b].add(new Edge(a,c));
        }
        int startToP = dijikstra(1,P);
        int PToV = dijikstra(P,V);
        int startToV = dijikstra(1,V);
        System.out.println(startToP+PToV <= startToV ? "SAVE HIM" : "GOOD BYE");
        
    }//end
    public static int dijikstra(int start, int destination) {
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.offer(new Edge(start,0));
    	int[] costs = new int[V+1];
    	Arrays.fill(costs,100000000);
    	costs[start] = 0;
    	int ans = 0;
    	while(!pq.isEmpty()) {
    		Edge now = pq.poll();
    		if(now.vertex == destination) {
    			ans = costs[destination];
    			break;
    		}
    		for(int i=0; i<edges[now.vertex].size(); i++) {
    			Edge next = edges[now.vertex].get(i);
    			if(costs[next.vertex]>costs[now.vertex]+next.cost) {
    				pq.offer(new Edge(next.vertex, costs[now.vertex]+next.cost));
    				costs[next.vertex] = costs[now.vertex]+next.cost;
    			}
    		}
    	}
    	return ans;
    }
}