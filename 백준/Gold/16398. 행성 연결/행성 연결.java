import java.util.*;
import java.io.*;

public class Main {
    static public class Edge implements Comparable<Edge>{
        int s,e,w;
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }

    }
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //부모 초기화
        parents = new int[N];
        for(int i=0; i<N; i++) parents[i] = i;
        List<Edge> list = new ArrayList<>();
        //간선 리스트 생성
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int w = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                list.add(new Edge(i,j,w));
            }
        }
        Collections.sort(list);
        int vertexCnt = 0;
        long cost = 0;
        for(Edge e : list) {
            if(union(e.s, e.e)) {
                cost += e.w;
                if(++vertexCnt==N) break;
            }
        }
        System.out.println(cost);
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
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }
}