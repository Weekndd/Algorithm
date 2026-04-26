import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int num, wei;

        public Node(int num, int wei) {
            this.num = num;
            this.wei = wei;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.wei,o.wei);
        }
    }
    static int N, start, end, result[], preNode[];
    static List<Node>[] nodeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[N+1];

        for(int i=1; i<=N; i++) nodeList[i] = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodeList[s].add(new Node(e,w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        //end input

        result = new int[N+1];
        for(int i=1; i<=N; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        boolean[] visited = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        result[start] = 0;
        preNode = new int[N+1];
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.num]) continue; //check point
            if(now.num==end) break;
            visited[now.num] = true;

            for(int i=0; i<nodeList[now.num].size(); i++) {
                Node nextNode = nodeList[now.num].get(i);
                if(visited[nextNode.num]) continue;
                if(result[nextNode.num]>result[now.num]+nextNode.wei) {
                    result[nextNode.num] = result[now.num]+nextNode.wei;
                    pq.offer(new Node(nextNode.num, result[nextNode.num]));
                    preNode[nextNode.num] = now.num;
                }
            }
        }//end while

        System.out.println(result[end]);
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while(preNode[end]!=0) {
            cnt++;
            stack.push(preNode[end]);
            end = preNode[end];
        }
        System.out.println(cnt);
        while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
    }//end main
}