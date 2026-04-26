import java.util.*;
import java.io.*;

public class Main {
    static public class Edge implements Comparable<Edge> {
        int s, e, w;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Edge(s, e, w));
        }
        Collections.sort(list);

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        int vertex = 0;
        int cost = 0;
        int maxWeight = 0;

        for (Edge e : list) {
            if (union(e.s, e.e)) {
                cost += e.w;
                maxWeight = e.w;  // 가장 최근에 추가한 간선의 가중치를 업데이트
                if (++vertex == N - 1) break;
            }
        }

        // 가장 큰 간선의 가중치를 빼서 두 마을로 분리
        System.out.println(cost - maxWeight);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        if (rootA > rootB) parents[rootA] = rootB;
        else parents[rootB] = rootA;
        return true;
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}