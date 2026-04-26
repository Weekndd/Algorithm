import java.util.*;
import java.io.*;
class Main{
    static public class Edge implements Comparable<Edge>{
        int start, end, wei;

        public Edge(int start, int end, int wei) {
            this.start = start;
            this.end = end;
            this.wei = wei;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.wei, o.wei);
        }
    }
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        for(int i=1; i<=V; i++) parent[i] = i;
        List<Edge> list = new ArrayList<>();
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Edge(s,e,w));
        }
        Collections.sort(list);
        int cnt = 0;
        int cost = 0;
        for(Edge e : list) {
            if(union(e.start, e.end)) {
                cost += e.wei;
                if(++cnt == V-1) break;
            }
        }
        System.out.println(cost);
    }//end main
    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;
        if(aRoot>bRoot) parent[aRoot] = bRoot;
        else parent[bRoot] = aRoot;
        return true;
    }
    public static int find(int a) {
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
}