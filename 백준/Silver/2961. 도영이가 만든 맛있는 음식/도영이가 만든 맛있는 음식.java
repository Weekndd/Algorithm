import java.io.*;
import java.util.*;

public class Main {
	static int N, depth, S, B;
	static long min;
	static long arr[][];
	static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new long[N][2];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int S = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	arr[i] = new long[] {S,B};
        }//end input
        min = Integer.MAX_VALUE;
        
        visited = new boolean[N];
        recur(0, 1, 0);
        System.out.println(min);
	}//end main
    
    static public void recur(int depth, long S, long B) {
    	if(depth!=0) min = Math.min(min, Math.abs(S-B));
    	for(int i=depth; i<N; i++) {
    		recur(i+1, S*arr[i][0], B+arr[i][1]);
    	}
    }
}
