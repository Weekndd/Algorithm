import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N*2-1];
        for(char[] c : arr) {
            Arrays.fill(c,' ');
        }
        recur(0,N-1,N);
        StringBuilder sb = new StringBuilder();
        for(char[] i : arr) {
            for(char j : i) sb.append(j);
            sb.append("\n");
        }
        System.out.println(sb);
    }//end main
    static public void recur(int r, int c, int size) {
        if(size==3) {
            arr[r][c] = '*';
            arr[r+1][c-1] = arr[r+1][c+1] = '*';
            arr[r+2][c-2] = arr[r+2][c-1] = arr[r+2][c] = arr[r+2][c+1] = arr[r+2][c+2]= '*';
        }
        else {
            int newSize = size/2;
            recur(r,c,newSize);
            recur(r+newSize, c+newSize, newSize);
            recur(r+newSize, c-newSize, newSize);
        }
    }
}