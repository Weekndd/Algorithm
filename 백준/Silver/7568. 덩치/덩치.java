import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new  StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			
			list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}//end Test
		
		int count = 1;
		
		for(int i=0; i<list.size(); i++) {
			
			for(int j=0; j<list.size(); j++) {
				if (i == j) continue;
				if(list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1]) {
					count++;
				}
			}
			sb.append(count+" ");
			count = 1;
		}
		System.out.println(sb);
	}
}