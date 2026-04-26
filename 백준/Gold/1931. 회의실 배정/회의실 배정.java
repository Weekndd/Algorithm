import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	static int count = 1;
	static int[][] arr;
	static int T;

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		arr = new int[T][2];
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
		}
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 2번째 원소를 기준으로 오름차순 정렬
                int result = Integer.compare(o1[1], o2[1]);

                // 2번째 원소가 같으면 1번째 원소를 오름차순 정렬
                if (result == 0) {
                    result = Integer.compare(o1[0], o2[0]);
                }
                return result;
            }
        });
		int end = arr[0][1];
		for(int i=1; i<T; i++) {
			
			if(end<=arr[i][0]) {
				end = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
	
}