import java.util.*;
import java.io.*;

class Main {
	static int[] nums = new int[10];
	static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        
        for(int i=0; i<num.length(); i++) {
        	int c = num.charAt(i)-'0';
        	
        	if(c==6 || c==9) {
        		if(nums[6]+nums[9]==0) plus();
        	}
        	else if(nums[c]==0) plus();
        	nums[c]--;
        }
        System.out.println(cnt);
    }//end main
    static void plus() {
    	for(int i=0; i<=9; i++) {
    		nums[i]++;
    	}
    	cnt++;
    }
}