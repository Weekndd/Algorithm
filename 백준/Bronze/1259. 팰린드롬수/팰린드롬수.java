import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			Deque<Character> d = new ArrayDeque<>();
			boolean flag = false;
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			char[] arr = str.toCharArray();
			for(int i=0; i<arr.length; i++) {
				d.offer(arr[i]);
			}
			while(d.size()>1) {
				if(!(d.pollFirst() == d.pollLast())) {
					System.out.println("no");
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("yes");
			}
			
		}
	}
}