import java.util.*;
import java.io.*;

class Main {
	static String str;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        check = new boolean[str.length()];
        recur(0,str.length()-1);
        System.out.println(sb);
    }//end main
    
    static void recur(int left, int right) {
    	if(left>right) return;
    	int min = left;
    	for(int i=left; i<=right; i++) {
    		char c = str.charAt(i);
    		if(str.charAt(min)>c) {
    			min = i;
    		}
    	}
    	check[min] = true;
    	
    	for(int i=0; i<str.length(); i++) {
    		if(check[i]) sb.append(str.charAt(i));
    	}
    	sb.append("\n");
    	recur(min+1, right);
    	recur(left, min-1);
    }//end recur
}