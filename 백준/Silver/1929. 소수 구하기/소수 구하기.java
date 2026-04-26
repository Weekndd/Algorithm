import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		boolean flag = false;
		
		for(int i=start; i<=end; i++) {
			if(i==1) {
				continue;
			}
			if(i==2) {
				sb.append(i+"\n");
				continue;
			}
			else {
				for(int j=2; j<=Math.sqrt(i); j++) {
					if(i%j==0) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					sb.append(i+"\n");
				}
				flag = false;
			}
			
		}//end for i
		System.out.println(sb);
		
	}
	
}