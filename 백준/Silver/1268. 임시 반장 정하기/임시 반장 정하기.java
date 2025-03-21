import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N+1][6];
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=5; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        int ans = 0;
        int max = 0;
        for(int n=1; n<=N; n++) {
        	boolean[] check = new boolean[N+1];
        	int cnt = 0;
        	for(int i=1; i<=N; i++) {
        		if(n==i) continue;
            	for(int j=1; j<=5; j++) {
            		if(arr[n][j]==arr[i][j] && !check[i]) {
            			cnt++;
            			check[i] = true;
            		}
            	}
            }
        	if(cnt>max) {
        		ans = n;
        		max = cnt;
        	}
        }
        System.out.println(ans==0?1:ans);
    }//end main
}