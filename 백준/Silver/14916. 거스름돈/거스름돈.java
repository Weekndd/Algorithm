import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(num>=0) {
			if(num%5 == 0) {
				count = count + (num/5);
				break;
			}
			else {
				num = num - 2;
				count ++;
			}
		}
		if(num<0) {
			System.out.println(-1);
		}
		else {
			System.out.println(count);
		}
		
	}
}