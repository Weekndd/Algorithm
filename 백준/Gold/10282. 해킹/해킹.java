import java.util.*;
import java.io.*;

public class Main { //백준 10282번 해킹
    public static class Node implements Comparable<Node>{
        int V, W;
        public Node(int V, int W) {
            this.V = V;
            this.W = W;
        }
        @Override
        public int compareTo(Node o1) {
            return this.W-o1.W;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            List<List<Node>> list = new ArrayList<>();
            //리스트 초기화
            for(int i=0; i<=N; i++) list.add(new ArrayList<Node>());
            //간선 입력
            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list.get(b).add(new Node(a,s));
            }

            //다익스트라
            int[]dis = new int[N+1];
            boolean[] visited = new boolean[N+1];
            Arrays.fill(dis,Integer.MAX_VALUE); //거리값 초기화
            dis[C] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(C,0));
            while(!pq.isEmpty()) {
                Node now = pq.poll();
                if(visited[now.V]) continue;
                visited[now.V] = true;

                for(int i=0; i<list.get(now.V).size(); i++) {
                    Node next = list.get(now.V).get(i);
                    if(dis[next.V]<=now.W+next.W) continue;
                    dis[next.V] = now.W+next.W;
                    pq.offer(new Node(next.V, now.W+next.W));
                }
            }//end while
            int time = 0;
            int hackedPC = 0;
            for(int i=1; i<=N; i++) {
                if(dis[i]!=Integer.MAX_VALUE) {
                    hackedPC++;
                    time = Math.max(time,dis[i]);
                }
            }
            sb.append(hackedPC+" "+time+"\n");
        }//end test
        System.out.println(sb);
    }//end main
}