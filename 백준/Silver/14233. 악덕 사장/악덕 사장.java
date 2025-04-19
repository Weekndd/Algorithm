import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int deadLine = 0;
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int left = 1;
        int right = arr[0];
        int ans = 0;
        while(left<=right) {
        	int mid = left+(right-left)/2;
        	int day = 0;
        	boolean flag = false;
        	for(int i=0; i<N; i++) {
        		day += mid;
        		if(arr[i]<day) {
        			flag = true;
        		}
        	}
        	
        	if(!flag) {
        		ans = mid;
        		left = mid+1;
        	}
        	else {
        		right = mid-1;
        	}
        }//end while
        System.out.println(ans);
    }
}