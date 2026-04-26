import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<int[]>> list; // 2차원 배열 대신 List로 변환
    static int[][] minEdge;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        // arr 초기화
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list.get(A).add(new int[] {B, W});
            list.get(B).add(new int[] {A, W});
        }

        // minEdge 초기화
        minEdge = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(minEdge[i], Integer.MAX_VALUE);
        }

        // 최소 간선 비용 계산
        for (int i = 1; i <= N; i++) {
            for (int[] neighbor : list.get(i)) {
                int j = neighbor[0];
                int weight = neighbor[1];
                if (weight != 0) {
                    visited = new boolean[N + 1];
                    visited[i] = true;
                    minEdge[i][j] = weight;
                    findMinEdge(i, j, weight);
                }
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int j = 1; j <= N; j++) {
                if (minEdge[num][j] != Integer.MAX_VALUE && minEdge[num][j] >= K) ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void findMinEdge(int start, int target, int minCost) {
        visited[target] = true;
        for (int[] next : list.get(target)) {
            int nextIdx = next[0];
            int weight = next[1];
            if (!visited[nextIdx]) {
                findMinEdge(start, nextIdx, Math.min(minCost, weight));
            }
        }
        minEdge[start][target] = minCost;
        minEdge[target][start] = minCost;
    }
}