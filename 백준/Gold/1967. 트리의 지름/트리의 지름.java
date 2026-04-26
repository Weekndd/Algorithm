import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int next;
        int weigh;
        public Node(int next, int weigh) {
            this.next = next;
            this.weigh = weigh;
        }
    }
    static int N;
    static List<List<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,weigh));
            list.get(b).add(new Node(a,weigh));
        }//end input

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            sum=0;
            dfs(i);
        }
        System.out.println(max);

    }//end main
    static public void dfs(int start) {
        visited[start] = true;
        for(int i=0; i<list.get(start).size(); i++) {
            if(!visited[list.get(start).get(i).next]) {
                sum+= list.get(start).get(i).weigh;
                dfs(list.get(start).get(i).next);
                sum-= list.get(start).get(i).weigh;
            }
        }
        if(max<sum) max = sum;
    }
}