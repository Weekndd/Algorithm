import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(B != A) {
        	if(A > B) {
        		System.out.println(-1);
        		System.exit(0);
        	}
        	else if(B % 10 == 1) {
        		B = B/10;
        	}
        	else if(B % 2 == 0) {
        		B = B/2;
        	}
        	else {
        		System.out.println(-1);
        		System.exit(0);
        	}
        	cnt++;
        }
        System.out.println(cnt);
    }//end main
}