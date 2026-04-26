import java.io.*;
import java.util.*;

public class Main { //플로이드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int INF = 9900001;

        //초기배열 INF로 초기화
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                arr[i][j] = INF;
                if(i==j) arr[i][j] = 0;
            }
        }

        //input
        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //같은 경로의 버스 중 요금이 더 싼 경우가 있음
            arr[start][end] = Math.min(cost, arr[start][end]);
        }

        //floyd_warshall
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        //output
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(arr[i][j]==INF) arr[i][j] = 0;  //INF값은 경로가 없는 곳 이기 떄문에 0으로 바꿔줌
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }//end main
}