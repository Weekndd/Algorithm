import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[] alp = new int[26];
        
        for(int i=0; i<N; i++) {
        	arr[i] = br.readLine();
        }//end input
        
        for(int i=0; i<N; i++) {
        	int temp = (int)Math.pow(10, arr[i].length()-1);
        	
        	for(int j=0; j<arr[i].length(); j++) {
        		alp[arr[i].charAt(j)-65] += temp;
        		temp /= 10;
        	} //end j for
        }//end i for
        
        Arrays.sort(alp);
        int res = 0;
        int index = 9;
        for(int i=alp.length-1; i>=0; i--) {
        	if(alp[i]==0) break;
        	res += alp[i]*index;
        	index--;
        }
        System.out.println(res);
    }
}