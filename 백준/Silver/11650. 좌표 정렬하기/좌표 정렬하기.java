import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {x,y});
		}
		Collections.sort(list, (o1,o2) -> o1[0] - o2[0]);
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] - o2[0] == 0) {
					return o1[1] - o2[1];
				}
				return 0;
			}
		});
		for(int i[] : list) {
			sb.append(i[0]+" "+i[1]+"\n");
		}
		System.out.println(sb);
		
	}
}