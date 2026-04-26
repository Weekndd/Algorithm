import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[]{1,1,2,2,2,8};
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(arr[i]-num).append(" ");
        }
        System.out.println(sb);
    }//end main
}
