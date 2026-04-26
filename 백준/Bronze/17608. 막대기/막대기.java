import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[N];
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	int cnt = 0;
    	int max = 0;
    	for(int i=N-1; i>=0; i--) {
    		int num = arr[i];
    		if(num>max) {
    			cnt++;
    			max = num;
    		}
    	}
    	System.out.println(cnt);
    }//end main
}