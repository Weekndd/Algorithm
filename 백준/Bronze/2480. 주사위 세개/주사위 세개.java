import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int A = arr[2];
        int B = arr[1];
        int C = arr[0];

        if(A==C){
            System.out.println(10000+ A *1000);
        }
        else if(A==B){
            System.out.println(1000+ A *100);
        }
        else if(B==C) {
            System.out.println(1000+B*100);
        }
        else {
            System.out.println(100* A);
        }

    }
}