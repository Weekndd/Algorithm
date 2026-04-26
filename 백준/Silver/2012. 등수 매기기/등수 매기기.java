import java.io.*;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        long count = 0;
        for(int i=1; i<=N; i++) {
        	if(arr[i] != i) {
        		count += Math.abs(arr[i]-i);
        	}
        }
        System.out.println(count);
    }//end main
}
