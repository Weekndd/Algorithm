import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[], temp[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }//end input

        temp = new int[N];
        temp[0] = arr[0];
        int LISLength = 1;

        for(int i=1; i<N; i++) {
            int target = arr[i];
            if(target>temp[LISLength-1]) {
                temp[LISLength++] = target;
                continue;
            }

            int left = 0;
            int right = LISLength;

            //lowerBound(타겟보다 같거나 큰 값 찾기)
            while(left<=right) {
                int mid = left+(right-left)/2;
                if(temp[mid]<target) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            temp[left]=target;
        }
        System.out.println(LISLength);
    }//end main
}