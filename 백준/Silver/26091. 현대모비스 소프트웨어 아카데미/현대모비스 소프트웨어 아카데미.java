import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int line = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	int left = 0;
    	int right = N-1;
    	int ans = 0;
    	while(left<right) {
    		int a = arr[left];
    		int b = arr[right];
    		if(a+b>=line) {
    			ans++;
    			left++;
    			right--;
    		} else if(a+b<line) {
    			left++;
    		}
    	}
    	System.out.println(ans);
    }//end main
}