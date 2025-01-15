import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        boolean[] broken = new boolean[N+1];
        for(int i=0; i<B; i++) {
        	broken[Integer.parseInt(br.readLine())] = true;
        }
        int cnt = 0;
        for(int i=1; i<=K; i++) {
        	if(broken[i]) cnt++;
        }
        int min = Integer.MAX_VALUE;
        for(int i=K+1; i<=N; i++) {
        	if(broken[i-K]) cnt--;
        	if(broken[i]) cnt++;
        	min = Math.min(min, cnt);
        }
        System.out.println(min);
    }//end main
}