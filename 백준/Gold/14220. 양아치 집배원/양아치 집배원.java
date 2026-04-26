import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static List<List<Node>> list;
    static int N, answer;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(cost==0) continue;
                list.get(j).add(new Node(i,cost));
            }
        }//end input
        if(N==1) {
            System.out.println(0);
            System.exit(0);
        }

        dp = new int[N+1][N];


        for(int i=1; i<=N; i++) { // 방문 도시 개수
            for(int j=0; j<N; j++) { // 각 도시 번호
                if(i==1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(list.get(j).isEmpty()) {
                    dp[i][j] = -1;
                }

                int min = Integer.MAX_VALUE;
                for(Node n : list.get(j)) {
                    if(dp[i-1][n.idx] != -1) {
                        int temp = n.cost + dp[i-1][n.idx];
                        min = Math.min(temp, min);
                    }
                }
                if(min != Integer.MAX_VALUE) {
                    dp[i][j] = min;
                }
                else {
                    dp[i][j] = -1;
                }
            }
        }
        answer=Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            if(dp[N][i] != 0) {
                answer = Math.min(answer,dp[N][i]);
            }
        }
        if(answer==Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }//end main
}