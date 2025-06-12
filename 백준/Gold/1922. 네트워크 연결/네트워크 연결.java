import java.io.*;
import java.util.*;
public class Main {
	static public class Network implements Comparable<Network>{
		int start, end, cost;
		public Network(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Network o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        parents = new int[V+1];
        for(int i=1; i<=V; i++) parents[i] = i;
        
        Network[] networks = new Network[E];
        for(int i=0; i<E; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	networks[i] = new Network(s, e, w);
        }
        Arrays.sort(networks);
        int cost = 0;
        int cnt = 0;
        
        for(Network n : networks) {
        	if(union(n.start,n.end)) {
        		cost += n.cost;
        		if(++cnt == V-1) break;
        	}
        }
        System.out.println(cost);
    }//end main
    static public boolean union(int a, int b) {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	if(aRoot == bRoot) return false;
    	if(aRoot>bRoot) parents[aRoot] = bRoot;
    	else parents[bRoot] = aRoot;
    	return true;
    }
    static public int find(int a) {
    	if(parents[a] == a) return a;
    	return parents[a] = find(parents[a]);
    }
    	
}