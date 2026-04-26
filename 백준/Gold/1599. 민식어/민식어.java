import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        for(int i=0; i<N; i++) {
            arr[i] = arr[i].replace("k","c");
            arr[i] = arr[i].replace("ng","n~");
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
            arr[i] = arr[i].replace("c","k");
            arr[i] = arr[i].replace("n~","ng");
        }
       for(String str : arr) System.out.println(str);

    }//end main
}