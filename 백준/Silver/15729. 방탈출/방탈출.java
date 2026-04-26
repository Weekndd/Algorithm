import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] originArr = new boolean[N];
        boolean[] arr = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            originArr[i] = num==0?false:true;
        }
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(originArr[i] == arr[i]) continue;
            cnt++;
            arr[i] = !originArr[i];
            if(i+2<N) {
                arr[i+1] = !arr[i+1];
                arr[i+2] = !arr[i+2];
            }
            else if(i+1<N) {
                arr[i+1] = !arr[i+1];
            }
        }
        System.out.println(cnt);
    }//end main
}