import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];
        for(int i=0; i<6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int shirt = 0;
        for(int i : arr) {
            shirt+= i/T;
            if(i%T!=0) shirt++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(shirt).append("\n").append(N/P).append(" ").append(N%P);
        System.out.println(sb);
    }
}
