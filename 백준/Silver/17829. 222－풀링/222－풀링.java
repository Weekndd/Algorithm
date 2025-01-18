import java.util.*;
import java.io.*;

public class Main {
	static int N, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        System.out.println(recur(N, 0, 0));
    }//end main
    
    static int recur(int size, int sr, int sc) {
    	int newSize = size/2;
    	List<Integer> list = new ArrayList<>();
    	if(newSize==1) {
    		for(int i=sr; i<=sr+newSize; i++) {
    			for(int j=sc; j<=sc+newSize; j++) {
    				list.add(arr[i][j]);
    			}
    		}
    		Collections.sort(list);
    		return list.get(2);
    	}
    	for(int i=sr; i<sr+size; i+=newSize) {
    		for(int j=sc; j<sc+size; j+=newSize) {
    			list.add(recur(newSize, i, j));
    		}
    	}
    	Collections.sort(list);
    	return list.get(2);
    }
}