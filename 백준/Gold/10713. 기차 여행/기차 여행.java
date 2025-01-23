import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 수
        int M = Integer.parseInt(st.nextToken()); // 여행일수
        int[] destination = new int[M];
        int[][] cost = new int[N + 1][3];

        // 여행 경로 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            destination[i] = Integer.parseInt(st.nextToken());
        }

        // 도시별 비용 입력
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // 누적 합 배열 생성
        int[] route = new int[N + 2];
        for (int i = 1; i < M; i++) {
            int start = Math.min(destination[i - 1], destination[i]);
            int end = Math.max(destination[i - 1], destination[i]);
            route[start + 1]++;
            route[end + 1]--;
        }

        // 이동 횟수 누적 계산
        for (int i = 1; i <= N; i++) {
            route[i] += route[i - 1];
        }

        // 최소 비용 계산
        long sum = 0;
        for (int i = 2; i <= N; i++) {
            if (route[i] > 0) {
                long costA = (long) route[i] * cost[i][0];
                long costB = (long) route[i] * cost[i][1] + cost[i][2];
                sum += Math.min(costA, costB);
            }
        }
        System.out.println(sum);
    }
}