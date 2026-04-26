import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] A = new int[K+1];
        int[] B = new int[K+1];
        A[0] = 1; B[0] = 0;
        A[1] = 0; B[1] = 1;
        for(int i=2; i<=K; i++) {
            A[i] = A[i-2]+A[i-1];
            B[i] = B[i-2]+B[i-1];
        }
        System.out.println(A[K]+" "+B[K]);
    }//end main
}