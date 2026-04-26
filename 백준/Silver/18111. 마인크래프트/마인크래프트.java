import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		int[][]arr = new int[H][W];
		int MAX = 0;
		int MIN = Integer.MAX_VALUE;
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>MAX) MAX = arr[i][j];
				if(arr[i][j]<MIN) MIN = arr[i][j];
			}
		}
		
		int result = Integer.MAX_VALUE;
		int resultDepth = 0;
		
		for(int Depth=MIN; Depth<=MAX; Depth++) {
			int INVENTORY = I;
			int time = 0;
			
			
			for(int i=0; i<H; i++) {

				for(int j=0; j<W; j++) {
					if(arr[i][j]>Depth) {
						time += ((arr[i][j] - Depth)*2);
						INVENTORY += (arr[i][j] - Depth);
					}
					if(arr[i][j]<Depth) {
						time += (Depth - arr[i][j]);
						INVENTORY -= (Depth - arr[i][j]);
					}
					
				}//end j for
				
			}//end i for
			if(INVENTORY<0) break;
			
			if(result>=time) {
				result = time;
				resultDepth = Depth;
			}
			
			
		}//end Depth
		System.out.println(result+" "+resultDepth);
		
		
	}
}