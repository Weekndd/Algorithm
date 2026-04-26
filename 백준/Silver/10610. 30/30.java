import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String[] nums = str.split("");
        Arrays.sort(nums);
        
		long sum = 0;
		boolean flag = false;
		for(int i=nums.length-1; i>=0; i--) {
			if(!nums[0].equals("0")) {
				flag = true;
				break;
			}
			sum += Integer.parseInt(nums[i]);
			sb.append(nums[i]);
		}
        if(sum%3 == 0 && !flag) System.out.println(sb);
        else System.out.println(-1);
    }//end main
}