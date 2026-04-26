import java.util.*;
import java.io.*;
class Main{
    static String[][] arr;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        recursion(0,0, N,false);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static public void recursion(int r, int c, int size, boolean blank) {
        if(blank) {
            for(int i=r; i<r+size; i++) {
                for(int j=c; j<c+size; j++) {
                    arr[i][j] = " ";
                }
            }
            return;
        }
        if(size == 1) {
            arr[r][c] = "*";
            return;
        }

        int newSize = size/3;
        int count = 0;
        for(int i=r; i<r+size; i+=newSize) {
            for(int j=c; j<c+size; j+=newSize) {
                count++;
                if(count==5) {
                    recursion(i, j, newSize, true);
                }
                else recursion(i, j, newSize, false);
            }
        }

    }
}