import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		BigInteger res = new BigInteger("0");
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			res = res.add(BigInteger.valueOf(str.charAt(i)-96).multiply(BigInteger.valueOf(31).pow(i)));
		}
		System.out.println(res.remainder(BigInteger.valueOf(1234567891)));
	}
}