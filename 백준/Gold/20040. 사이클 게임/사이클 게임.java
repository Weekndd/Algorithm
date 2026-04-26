import java.util.*;
import java.io.*;

public class Main {
    static int N, parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        
        for(int i=0; i<N; i++) {
        	parents[i] = i;
        }
        //부모노드 초기화
        int ans = 0;
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	if(!union(A,B)) {
        		ans = i+1;
        		break;
        	}
        }
        System.out.println(ans);
    }//end main
    
    public static boolean union(int a, int b) {
    	int rootA = find(a);
    	int rootB = find(b);
    	if(rootA == rootB) return false;
    	if(rootA>rootB) parents[rootA] = parents[rootB]; 
    	else parents[rootB] = parents[rootA];
    	return true;
    }//end union
    
    public static int find(int a) {
    	if(a == parents[a]) return a;
    	return parents[a] = find(parents[a]);
    }//end find
}