import java.util.*;
import java.io.*;

public class Main {
	static int N,M,jams[],max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jams = new int[M];
        for(int i=0; i<M; i++) {
        	jams[i] = Integer.parseInt(br.readLine());
        	max = Math.max(max,jams[i]);
        }
        System.out.println(parametricSearch(N));
    }//end main
    
    static int parametricSearch(int target) {
    	int left = 1;
    	int right = max;
    	
    	while(left<=right) {
    		int mid = left+(right-left)/2;
    		int sum = 0; //나눠줄 인원
    		for(int i=0; i<M; i++) {
    			sum += jams[i]/mid;
    			if(jams[i]%mid!=0) sum+=1;
    		}
    		if(sum>target) {
    			left = mid + 1;
    		}
    		else {
    			right = mid - 1;
    		}
    	}
    	return left;
    }
}