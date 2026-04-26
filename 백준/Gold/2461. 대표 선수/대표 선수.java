import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[] idxCnt = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
            Arrays.sort(arr[i]);
        }
        int res = Integer.MAX_VALUE;

        while(true) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i=0; i<N; i++) {
                if(min>arr[i][idxCnt[i]]) {
                    min = arr[i][idxCnt[i]];
                    minIdx = i;
                }
                max = Math.max(max, arr[i][idxCnt[i]]);
            }
            res = Math.min(res,max-min);
            if(++idxCnt[minIdx] >= M) break;
        }
        System.out.println(res);
    }//end main
}
