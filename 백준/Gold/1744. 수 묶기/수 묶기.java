import java.io.*;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int res = 0;
        int minusIdx = 0;
        while(minusIdx < N && arr[minusIdx] < 0) {
        	if(minusIdx+1 < N && arr[minusIdx+1] < 1) {
        		res += arr[minusIdx] * arr[minusIdx+1];
        		minusIdx += 2;
        	}
        	else {
        		res += arr[minusIdx];
        		minusIdx++;
        	}
        }
        
        int plusIdx = N-1;
        while(plusIdx >= 0 && arr[plusIdx] > 0) {
        	if(plusIdx-1 >= 0 && arr[plusIdx-1] > 1) {
        		res += arr[plusIdx] * arr[plusIdx-1];
        		plusIdx -= 2;
        	}
        	else {
        		res += arr[plusIdx];
        		plusIdx--;
        	}
        }
        System.out.println(res);
    }//end main
}
