import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String[] arr = new String[N];
    	for(int i=0; i<N; i++) {
    		String str = br.readLine();
    		int[] alp = new int[26];
    		Arrays.fill(alp,-1);
    		StringBuilder sb = new StringBuilder();
    		for(int j=0; j<str.length(); j++) {
    			char c = str.charAt(j);
    			if(alp[c-97]==-1) {
    				alp[c-97] = j;
    			}
    			sb.append(alp[c-97]);
    		}
    		arr[i] = sb.toString();
    	}
    	int cnt = 0;
    	for(int i=0; i<N; i++) {
    		String str = arr[i];
    		for(int j=i+1; j<N; j++) {
    			if(str.equals(arr[j])) cnt++;
    		}
    	}
    	System.out.println(cnt);
    }//end main
}