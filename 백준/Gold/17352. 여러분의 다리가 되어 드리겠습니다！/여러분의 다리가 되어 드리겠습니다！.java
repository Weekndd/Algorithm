import java.util.*;
import java.io.*;

public class Main {
	static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        parents = new int[N+1];
        for(int i=1; i<=N; i++) {
        	parents[i] = i;
        }
        //end initial
        
        for(int i=1; i<N-1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	union(a,b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
        	if(parents[i]==i) {
        		sb.append(i+" ");
        	}
        }
        System.out.println(sb);
    }//end main
    public static boolean union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA==rootB) {
    		return false;
    	}
    	if(rootA>rootB) parents[rootA] = rootB;
    	else parents[rootB] = rootA;
    	return true;
    }
    public static int find(int a) {
    	if(parents[a]==a) return a;
    	return parents[a] = find(parents[a]);
    }
}