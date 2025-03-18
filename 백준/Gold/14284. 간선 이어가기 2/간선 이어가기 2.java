import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int v, c;
		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
		public int compareTo(Edge e) {
			return this.c - e.c;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Edge>[] edges = new ArrayList[N+1];
        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	edges[a].add(new Edge(b,c));
        	edges[b].add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] cost = new int[N+1];
        Arrays.fill(cost, 100000000);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s,0));
        
        int ans = 0;
        while(!pq.isEmpty()) {
        	Edge now = pq.poll();
        	if(now.v==t) {
        		ans = now.c; 
        		break;
        	}
        	for(int i=0; i<edges[now.v].size(); i++) {
        		Edge next = edges[now.v].get(i);
        		if(now.c+next.c > cost[next.v]) continue;
        		cost[next.v] = now.c+next.c;
        		pq.offer(new Edge(next.v, now.c+next.c));
        	}
        }
        System.out.println(ans);
    }//end main
}