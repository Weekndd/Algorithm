import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(br.readLine());

        H = H+(M+A)/60;
        if(H >= 24) {
            H = H%24;
        }
        M = (M+A)%60;
        System.out.println(H+" "+M);
    }//end main
}