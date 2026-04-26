import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arrA = new int[N];
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            int[] arrB = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            int pa = 0;
            int pb = 0;
            int cnt = 0;
            while(pa<N && pb<M) {
                if(arrA[pa] <= arrB[pb]) {
                    pa++;
                }
                else {
                    cnt += N-pa;
                    pb++;
                }
            }
            sb.append(cnt).append("\n");
        }//end testCase
        System.out.println(sb);

    }//end main
}