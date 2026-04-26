import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R;
    static boolean[] visited;
    static int[] res;
    static List<List<Integer>> list = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException { //테트로미노
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[N+1];
        res = new int[N+1];
        dfs(R);

        for(int i=1; i<=N; i++) {
            System.out.print(res[i]+" ");
        }
    }//end main

    static public void dfs(int ver) {
        visited[ver] = true;
        res[ver] = ++count;
        List<Integer> nodeList = list.get(ver);
        Collections.sort(nodeList);
        for(int i : nodeList) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}