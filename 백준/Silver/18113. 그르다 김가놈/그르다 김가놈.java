import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //김밥수
        int K = Integer.parseInt(st.nextToken()); //꼬다리cm
        int M = Integer.parseInt(st.nextToken()); //최소 조각
        
        int max = 0;
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	max = Math.max(arr[i], max);
        }
        
        int left = 1;
        int right = max;
        int ans = 0;
        while(left<=right) {
        	int mid = left+(right-left)/2;
        	int cnt = 0;
        	for(int i=0; i<N; i++) {
        		int kimbap = arr[i];
        		if(kimbap<=K) continue; //K보다 작으면 폐기
        		else if(kimbap<2*K) { //2K보다 작으면 한쪽만 잘라냄
        			kimbap -= K;
        		}
        		else { //그 외는 양쪽 잘라냄
        			kimbap = kimbap-2*K;
        		}
        		cnt += kimbap/mid;
        	}
        	if(cnt>=M) {
        		ans = mid;
        		left = mid+1;
        	}
        	else {
        		right = mid-1;
        	}
        }//end while
        System.out.println(ans==0?-1:ans);
    }//end main
}