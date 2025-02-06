import java.util.*;
import java.io.*;

class Main {
	static int[] parents;
	static int N,M;
	static class Edge implements Comparable<Edge>{
		int S,E,C;
		Edge(int S, int E, int C) {
			this.S=S;
			this.E=E;
			this.C=C;
		}
		public int compareTo(Edge o1) {
			return this.C-o1.C;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;
            
            List<Edge> list = new ArrayList<>();
            int totalCost = 0;
            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int s = Integer.parseInt(st.nextToken());
            	int e = Integer.parseInt(st.nextToken());
            	int c = Integer.parseInt(st.nextToken());
            	totalCost += c;
            	list.add(new Edge(s,e,c));
            }
            parents = new int[N];
            for(int i=0; i<N; i++) parents[i] = i;
            Collections.sort(list);
            int cnt = 0;
            int cost = 0;
            for(Edge edge : list) {
            	int s = edge.S;
            	int e = edge.E;
            	if(union(s,e)) {
            		cost += edge.C;
            		if(++cnt==N-1) break;
            	}
            }
            sb.append((totalCost-cost)+"\n");
        }
        System.out.println(sb);
    }//end main
    public static boolean union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA == rootB) return false;
    	if(rootA>rootB) parents[rootA] = rootB;
    	else parents[rootB] = rootA;
    	return true;
    	
    }
    public static int find(int a) {
    	if(parents[a]==a) {
    		return a;
    	}
    	return parents[a] = find(parents[a]);
    }
}