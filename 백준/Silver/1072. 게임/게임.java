import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int X = Integer.parseInt(st.nextToken()); //게임 횟수
		int Y = Integer.parseInt(st.nextToken()); //이긴 게임
		long Z = (long)Math.floor(((double)Y*100/(double)X)); //승률
		
		long left = 1;
		long right = 1000000000;
		long mid = 0;
		long res = -1;
		
		while(left <= right) {
			mid = (left+right)/2;
			long rate = (long)Math.floor(
						(double)(Y+mid)/(double)(X+mid)*100
					);
			
			if(rate > Z) {
				right = mid-1;
				res = mid;
			}
			else if(rate <= Z){
				left = mid+1;
				
			}
		}
		
		System.out.println(res);
	}
}