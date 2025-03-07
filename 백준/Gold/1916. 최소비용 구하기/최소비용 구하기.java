import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int ver;
        int weigh;
        public  Node(int next, int weigh) {
            this.ver = next;
            this.weigh = weigh;
        }
        @Override
        public int compareTo(Node o) {
            return weigh - o.weigh;
        }
    }

    static List<List<Node>> list = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }//리스트 초기화

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        //end input

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] res = new int[N+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        pq.offer(new Node(start,0));
        res[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(!visited[now.ver]) {
                visited[now.ver] = true;

                for(Node next : list.get(now.ver)){
                    if(!visited[next.ver] && (res[now.ver] + next.weigh) < res[next.ver]) {
                        res[next.ver] = res[now.ver] + next.weigh;
                        pq.offer(new Node(next.ver, res[next.ver]));
                    }
                }
            }
            
        }
        System.out.println(res[end]);
    }//end main
}