import java.io.*;
import java.util.*;

public class Main {
	static int N,M, arr[];
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	combi(0,"");
    	System.out.println(sb);
    }
    
    static public void combi(int now, String str) {
    	if(now==M) {
    		if(!set.contains(str)) {
    			set.add(str);
    			sb.append(str+"\n");
    		}
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
    		combi(now+1, str+arr[i]+" ");
    	}
    }
}