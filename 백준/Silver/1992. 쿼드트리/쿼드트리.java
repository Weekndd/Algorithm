import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }//end input

        partition(0,0,N);
        System.out.println(sb);
    }//end main

    public static void partition(int r, int c, int size) {
        if(check(r,c,size)) {
            sb.append(arr[r][c]);
            return;
        }

        sb.append("(");
        int newSize = size/2;

        partition(r, c, newSize);                    //왼쪽 위
        partition(r,c+newSize, newSize);             //오른쪽 위
        partition(r+newSize, c, newSize);            //왼쪽 아래
        partition(r+newSize, c+newSize, newSize);    //오른쪽 아래
        sb.append(")");
    }//end partiton

    public static boolean check(int r, int c, int size) {
        char target = arr[r][c];

        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(arr[i][j]!=target) {
                    return false;
                }
            }
        }
        return true;
    }//end check
}