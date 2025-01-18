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
    	if(newSize==0) {
    		return arr[sr][sc];
    	}
    	int[] nums = new int[4];
    	nums[0]=recur(newSize,sr,sc);
    	nums[1]=recur(newSize,sr+newSize,sc);
    	nums[2]=recur(newSize,sr,sc+newSize);
    	nums[3]=recur(newSize,sr+newSize,sc+newSize);
    	Arrays.sort(nums);
    	return nums[2];
    }
}