import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = br.readLine();
		int cnt = 0;
		if(num.length()<2) {
			sb.append(cnt+"\n");
			sb.append(Integer.parseInt(num)!=0 && Integer.parseInt(num)%3==0? "YES" : "NO");
			System.out.println(sb);
			return;
		}
		while(true) {
			int sum = 0;
			for(int i=0; i<num.length(); i++) {
				sum += Integer.parseInt(String.valueOf(num.charAt(i)));
			}
			cnt++;
			if(sum<10) {
				sb.append(cnt+"\n");
				sb.append(sum!=0 && sum%3==0? "YES" : "NO");
				break;
			}
			else {
				num = String.valueOf(sum);
			}
		}
		System.out.println(sb);
	}
}
