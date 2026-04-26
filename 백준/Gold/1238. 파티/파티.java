import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int ver;
        int weigh;
        public Node(int ver, int weigh) {
            this.ver = ver;
            this.weigh = weigh;
        }

        @Override
        public int compareTo(Node o) {
            return weigh - o.weigh;
        }
    }

    static int N,M,X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        List<List<Node>> list = new ArrayList<>();
        List<List<Node>> reverslist = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
            reverslist.add(new ArrayList<>());
        } //리스트 초기화

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
            reverslist.get(b).add(new Node(a,w));
        } //end input
        int[] res1 = dijkstra(list);
        int[] res2 = dijkstra(reverslist);

        int ans = 0;
        for(int i=1; i<=N; i++) {
            ans = Math.max(ans ,res1[i]+res2[i]);
        }
        System.out.println(ans);
    }//end main

    public static int[] dijkstra(List<List<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X,0));

        boolean[] visited = new boolean[N+1];
        int[] res = new int[N+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[X] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(!visited[now.ver]) {
                visited[now.ver] = true;
                for(Node next : list.get(now.ver)) {
                    if(!visited[next.ver] && (res[now.ver] + next.weigh) < res[next.ver]) {
                        res[next.ver] = res[now.ver] + next.weigh;
                        pq.offer(new Node(next.ver, res[next.ver]));
                    }
                }
            }
        }
        return res;
    } //end dijkstra
}