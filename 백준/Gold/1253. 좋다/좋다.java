import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        //end input
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i<N; i++) {
        	int left = 0;
        	int right = N-1;
        	
        	while(true) {
        		if(left>=right) break;
        		if(arr[left]+arr[right]==arr[i]) {
        			if(left!=i  && right!=i) {
        				ans++;
        				break;
        			}
        			else if(left==i) left++;
        			else if(right==i) right--;
        		}
        		else if(arr[left]+arr[right]<arr[i]) left++;
        		else if(arr[left]+arr[right]>arr[i]) right--;
        	}//end while
        }
        System.out.println(ans);
    }//end main
}