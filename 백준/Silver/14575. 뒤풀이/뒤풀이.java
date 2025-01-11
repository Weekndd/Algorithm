import java.util.*;
import java.io.*;

class Main {
	static class Person{
		int min, max;
		Person(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 참가자 수
        int T = Integer.parseInt(st.nextToken()); // 술의 총량
        Person[] arr = new Person[N];
        int minSum = 0;
        int maxSum = 0;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int min = Integer.parseInt(st.nextToken());
        	int max = Integer.parseInt(st.nextToken());
        	minSum += min;
        	maxSum += max;
        	arr[i] = new Person(min, max);
        }
        if(minSum>T || maxSum<T) {
        	System.out.println(-1);
        	return;
        }
        
        int left = 0;
        int right = T;
        
        while(left<=right) {
        	int mid = left+(right-left)/2;
        	int total = 0;
        	boolean flag = false;
        	for(int i=0; i<N; i++) {
        		Person per = arr[i];
        		if(per.min>mid) {
        			flag = true;
        			break;
        		}
        		total += Math.min(mid,per.max);
        	}
        	if(flag) {
        		left = mid+1;
        		continue;
        	}
        	if(total>=T) {
        		right = mid-1;
        	}
        	else {
        		left = mid+1;
        	}
        }
        System.out.println(left);
    }//end main
}