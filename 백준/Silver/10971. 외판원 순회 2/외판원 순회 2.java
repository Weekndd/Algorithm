import java.io.*;
import java.util.*;

public class Main {
    static int N, min;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;

        for (int start = 0; start < N; start++) {
            visited = new boolean[N];
            visited[start] = true;
            recur(start, start, 0, 0);
        }

        System.out.println(min);
    }

    static public void recur(int start, int idx, int cnt, int dis) {
        if (cnt == N - 1) {
            if (arr[idx][start] != 0) {
                dis += arr[idx][start];
                min = Math.min(dis, min);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[idx][i] != 0) {
                visited[i] = true;
                recur(start, i, cnt + 1, dis + arr[idx][i]);
                visited[i] = false;
            }
        }
    }
}