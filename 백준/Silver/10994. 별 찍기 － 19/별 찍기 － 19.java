import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int size = 4*(N-1)+1;
        arr = new String[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                arr[i][j] = " ";
            }
        }//초기화
        recursion(0,0,size);

        for(String[] i : arr) {
            for(String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }

    }
    static public void recursion(int r, int c, int size) {

        if(size == 1) {
            arr[r][c] = "*";
            return;
        }
        int newSize = size - 4;
        boolean flag = false;
        for(int i=r; i<size+r; i++) {
            for(int j=c; j<size+c; j++) {
                if(!flag) {
                    recursion(r+2,c+2,newSize);
                    flag = true;
                }
                if(i==r || i==size+r-1) {
                    arr[i][j] = "*";
                    continue;
                }
                else {
                    arr[i][c] ="*";
                    arr[i][c+size-1] ="*";
                }
            }
        }

    }//end recursion
}
