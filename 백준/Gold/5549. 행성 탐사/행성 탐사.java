import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        int[][][] prefixSum = new int[N+1][M+1][3];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                char terrain = str.charAt(j - 1);
                prefixSum[i][j][0] = prefixSum[i - 1][j][0] + prefixSum[i][j - 1][0] - prefixSum[i - 1][j - 1][0];
                prefixSum[i][j][1] = prefixSum[i - 1][j][1] + prefixSum[i][j - 1][1] - prefixSum[i - 1][j - 1][1];
                prefixSum[i][j][2] = prefixSum[i - 1][j][2] + prefixSum[i][j - 1][2] - prefixSum[i - 1][j - 1][2];
                
                if (terrain == 'J') prefixSum[i][j][0]++;
                else if (terrain == 'I') prefixSum[i][j][1]++;
                else if (terrain == 'O') prefixSum[i][j][2]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<K; k++) {
        	st = new StringTokenizer(br.readLine());
        	int sr = Integer.parseInt(st.nextToken());
        	int sc = Integer.parseInt(st.nextToken());
        	int er = Integer.parseInt(st.nextToken());
        	int ec = Integer.parseInt(st.nextToken());
        	
        	int jungle = prefixSum[er][ec][0] - prefixSum[sr-1][ec][0]-prefixSum[er][sc - 1][0] + prefixSum[sr-1][sc-1][0];
        	int ice = prefixSum[er][ec][1] - prefixSum[sr-1][ec][1]-prefixSum[er][sc - 1][1] + prefixSum[sr-1][sc-1][1];
        	int ocean = prefixSum[er][ec][2] - prefixSum[sr-1][ec][2]-prefixSum[er][sc - 1][2] + prefixSum[sr-1][sc-1][2];
        	
        	sb.append(jungle+" "+ocean+" "+ice+"\n");
        }
        System.out.println(sb);
    }//end main
}