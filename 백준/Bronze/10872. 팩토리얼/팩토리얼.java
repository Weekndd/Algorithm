import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if(num == 0) {
			System.out.println(1);
		}
		else {
			int sum = 1;
			for(int i=1; i<=num; i++) {
				sum *= i;
			}
			System.out.println(sum);
		}
    }
}