import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int NUM = Integer.parseInt(br.readLine());
		
		for(int i=NUM; i>0; i--) {
			String str = String.valueOf(i);
			int temp = 0;
			
			for(int j=0; j<str.length(); j++) {
				temp += Integer.parseInt(String.valueOf(str.charAt(j)));
			}//end j for
			
			if(temp+i == NUM) {
				sb.setLength(0);
				sb.append(i);		
			}			
		}//end i for
		
		if(sb.length() == 0) {
			sb.append(0);
		}
		System.out.println(sb);
		
		
	}
}