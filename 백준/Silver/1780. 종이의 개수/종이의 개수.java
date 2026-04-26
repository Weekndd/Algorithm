import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int A = 0;
    static int B = 0;
    static int C = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }//end input
        partition(0,0,N);
        System.out.println(A);  //-1
        System.out.println(B);  // 0
        System.out.println(C);  // 1

    }//end main
    public static void partition(int r, int c, int size) {
        if(check(r, c, size)) {
            if(arr[r][c] == -1) A++;
            else if(arr[r][c] == 0) B++;
            else C++;
            return;
        }

        int newSize = size/3;
        partition(r, c, newSize);                         // 왼쪽 위
        partition(r, c+newSize, newSize);                 // 중앙 위
        partition(r, c+2*newSize, newSize);               // 오른쪽 위

        partition(r+newSize, c, newSize);                 // 왼쪽 중간
        partition(r+newSize, c+newSize, newSize);         // 중앙 중간
        partition(r+newSize, c+2*newSize, newSize);       // 오른쪽 중간

        partition(r+2*newSize, c, newSize);               // 왼쪽 아래
        partition(r+2*newSize, c+newSize, newSize);       // 중앙 아래
        partition(r+2*newSize, c+2*newSize, newSize);     // 오른쪽 아래

    }//end partiton

    static public boolean check(int r, int c, int size) {
        int target = arr[r][c];

        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(target != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }//end check
}