import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int num = Integer.parseInt(st.nextToken());
		int count = 1;
		int room = 1;
		
		while(true) {
			if(num<=room) {
				break;
			}
			room =room+(6*count);
			count++;
		}
		System.out.println(count);
		
	}
}