import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { //테트로미노
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Node node = new Node(A,"");
            Node result = new Node(B,"");
            boolean[] visited = new boolean[10000];
            Queue<Node> que = new LinkedList<>();
            que.add(node);
            visited[A] = true;
            while(!que.isEmpty()) {
                Node nowNode = que.poll();
                int nowNum= nowNode.num;
                int D = (nowNum*2) % 10000;
                int S = nowNum==0 ? 9999 : nowNum-1;
                int L = (nowNum%1000)*10+(nowNum/1000);
                int R = (nowNum%10)*1000+(nowNum/10);

                if(!visited[D]) {
                    Node nextNode = new Node(D, nowNode.command+"D");
                    if(B==D) {
                        result.command = nextNode.command;
                        break;
                    }
                    visited[D] = true;
                    que.offer(nextNode);
                }
                if(!visited[S]) {
                    Node nextNode = new Node(S, nowNode.command+"S");
                    if(B==S) {
                        result.command = nextNode.command;
                        break;
                    }
                    visited[S] = true;
                    que.offer(nextNode);
                }
                if(!visited[L]) {
                    Node nextNode = new Node(L, nowNode.command+"L");
                    if(B==L) {
                        result.command = nextNode.command;
                        break;
                    }
                    visited[L] = true;
                    que.offer(nextNode);
                }
                if(!visited[R]) {
                    Node nextNode = new Node(R, nowNode.command+"R");
                    if(B==R) {
                        result.command = nextNode.command;
                        break;
                    }
                    visited[R] = true;
                    que.offer(nextNode);
                }
            }//end whild
            sb.append(result.command).append("\n");
        }
        System.out.println(sb);
    }//end main

    static class Node {
        int num;
        String command;

        public Node(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

}