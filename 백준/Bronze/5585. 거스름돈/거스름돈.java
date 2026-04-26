import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] change = {500,100,50,10,5,1};
		int num = 1000-Integer.parseInt(br.readLine());
		int count = 0;
		
		while(num!=0) {
			for(int i : change) {
				if(num>=i) {
					num = num - i;
					count++;
					break;
				}
			}
			
		}//end while
		System.out.println(count);
		
		
	}
}