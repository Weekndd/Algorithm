import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] wire = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken()); //A전봇대
            wire[i][1] = Integer.parseInt(st.nextToken()); //B전봇대
        }
        Arrays.sort(wire,(o1,o2)-> o1[0]-o2[0]); //A전봇대 기준으로 정렬

        //A와 B를 연결했을 때 교차하지 않기 위해서는
        //이전의 B전봇대보다 커야한다.
        int[] dp = new int[N];
        for(int i=0; i<N; i++) {
            dp[i] = 1; //최소 개수 1개로 초기화
            for(int j=0; j<i; j++) {
                if(wire[i][1]>wire[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max=0;
        for(int i : dp) {
            if(i>max) max = i;
        }
        System.out.println(N-max);
    }//end main
}