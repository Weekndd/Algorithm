import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//배열 입력받기
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//정렬해야만 이진탐색이 가능하다.
		Arrays.sort(arr);
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken()); 
			
			//이진탐색을 위한 인덱스 객체
			int low = 0;
			int high = arr.length-1;
			boolean flag = false;
			
			//이진탐색 반복문
			while(low<=high) {
				int mid = (low+high)/2;
				
				if(key < arr[mid]) {
					high = mid-1;
				}
				else if(key > arr[mid]) {
					low = mid+1;
				}
				else {
					sb.append(1+"\n");
					flag = true;
					break;
				}
				
			}
			if(!flag) {
				sb.append(0+"\n");
			}
			
		}
		System.out.println(sb);
	}
}