import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		int A = 0;
		int B = 0;
		char before = arr[0];
		boolean isSame = false;
		if(arr[0] == '1') A++;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == before) {
				isSame = true;
			}
			else {
				isSame = false;
			}
			if(arr[i] == '1' && !isSame) {
				A++;
			}
			before = arr[i];
		}//end for 
		
		before = arr[0];
		isSame = false;
		if(arr[0] == '0') B++;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == before) {
				isSame = true;
			}
			else {
				isSame = false;
			}
			if(arr[i] == '0' && !isSame) {
				B++;
			}
			before = arr[i];
		}//end for 
		System.out.println(Math.min(A, B));
	}//end main
}