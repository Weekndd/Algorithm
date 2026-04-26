import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] LIS = new int[N];
        int[] seq = new int[N];
        int len = 1;
        LIS[0]=arr[0];
        seq[0]=1;
        int maxIdx = 0;
        for(int i=1; i<N; i++) {
            int target = arr[i];
            if(LIS[len-1]<target) {
                LIS[len] = target;
                len++;
                seq[i] = len;
                maxIdx = i;
                continue;
            }
            int left = 0;
            int right = len-1;
            while(left<=right) {
                int mid = left+(right-left)/2;
                if(LIS[mid]<target) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            LIS[left] = target;
            seq[i] = left+1;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        sb.append(len+"\n");
        int temp = len;
        for(int i=maxIdx; i>=0; i--) {
            if(temp<0) break;
            if(seq[i]==temp) {
                list.add(arr[i]);
                temp--;
            }
        }
        Collections.sort(list);
        for(int i : list) sb.append(i+" ");
        System.out.println(sb);
    }//end main
}