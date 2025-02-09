import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int t=0; t<T; t++) {
    		
    		String str = br.readLine();
    		int N = (int) Math.sqrt(str.length());
    		char[][] password = new char[N][N];
    		
    		int cnt = 0;
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N; j++) {
    				password[i][j] = str.charAt(cnt);
    				cnt++;
    			}
    		}
    		
    		for(int i=N-1; i>=0; i--) {
    			for(int j=0; j<N; j++) {
    				sb.append(password[j][i]);
    			}
    		}
    		sb.append("\n");
    	}
        System.out.println(sb);
    }//end main
}