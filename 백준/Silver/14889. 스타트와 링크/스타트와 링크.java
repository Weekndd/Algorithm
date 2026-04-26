import java.util.*;
import java.io.*;

public class Main {
    static int arr[][], N, ans =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //end input
        combination(0, 0,0);
        System.out.println(ans);
    }//end main

    static public void combination(int idx, int cnt, int m) {
        if(cnt==N/2) {
            int sumA = 0, sumB = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if((m&(1<<i))!=0 && (m&(1<<j))!=0) sumA += arr[i][j];
                    else if((m&(1<<i))==0 && (m&(1<<j))==0) sumB+=arr[i][j];
                }
            }
            ans = Math.min(Math.abs(sumA-sumB), ans);
            return;
        }//기저조건end

        for(int i=idx; i<N; i++) {
            combination(i+1, cnt+1, m|(1<<i));  // 선택된 인덱스를 비트마스크에 추가
        }
    }
}