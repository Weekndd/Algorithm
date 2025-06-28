import java.util.*;
import java.io.*;

public class Main {
    public static class Edge implements Comparable<Edge>{
        int E, W;
        public Edge(int E, int W) {
            this.E = E;
            this.W = W;
        }
        @Override
        public int compareTo(Edge o1) {
            return this.W-o1.W;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> list = new ArrayList<>();
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list.get(A).add(new Edge(B,W));
            list.get(B).add(new Edge(A,W));
        }
        int[] res = new int[N+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        //초기비용 초기화

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(1,0));
        res[1] = 0;
        visited[1] = true;
        while(!que.isEmpty()) {
            Edge now = que.poll();
            visited[now.E] = true;
            for(Edge next : list.get(now.E)) {
                if(visited[next.E]) continue;
                if(res[next.E] < now.W+next.W) continue;
                if(res[next.E] > now.W+next.W) {
                    res[next.E] = now.W+next.W;
                    que.offer(new Edge(next.E, res[next.E]));
                }
            }
        }//end while
        System.out.println(res[N]);
    }//end main
}