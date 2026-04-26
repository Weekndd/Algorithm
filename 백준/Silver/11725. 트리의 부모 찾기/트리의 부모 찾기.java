import java.io.*;
import java.util.*;

public class Main {  //음식물 피하기
    static int N;
    static List<List<Integer>> graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }//그래프 초기화

        visited = new boolean[N+1];
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }
        dfs(1);
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb);
    }//end main

    public static void dfs(int ver) {
        visited[ver] = true;
        for(int next : graph.get(ver)) {
            if(visited[next]) continue;
            parent[next] = ver;
            dfs(next);
        }
    }//end dfs
}