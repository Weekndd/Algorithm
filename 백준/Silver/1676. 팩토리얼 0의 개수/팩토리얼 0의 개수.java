import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger sum = new BigInteger("1");
		for(int i=1; i<=N; i++) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		String strN = String.valueOf(sum);
		int count = 0;
		for(int i=strN.length()-1; i>=0; i--) {
			if(strN.charAt(i) == '0') {
				count++;
			}
			else {
				break;
			}
		}
		System.out.println(count);
		
	}
}