import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            int[] arrA = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            int M = Integer.parseInt(br.readLine());
            int[] arrB = new int[M+1];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<M; i++) {
                int target = arrB[i];
                int s = 0;
                int e = N;
                boolean flag = false;
                while(s<=e) {
                    int m = (s+e)/2;
                    if(arrA[m]==target) {
                        flag = true;
                        break;
                    }
                    if(target<arrA[m]) e=m-1;
                    else s=m+1;
                }
                sb.append(flag?1:0).append("\n");
            }
            System.out.print(sb);

        }//end T
    }//end main
}