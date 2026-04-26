import java.util.*;
import java.io.*;

public class Main {
    static int N, L, arr[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //end input
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(checkRow(i)) cnt++;
            if(checkCol(i)) cnt++;
        }
        System.out.println(cnt);
    }//end main
    public static boolean checkRow(int row) {
        visited = new boolean[N];
        for(int i=0; i<N-1; i++) {
            int diff = arr[row][i] - arr[row][i+1];
            if(diff>1 || diff<-1) return false; //높이 차이가 1이상이면 false
            else if(diff==-1) { //오르막이면
                for(int j=0; j<L; j++) {
                    if(i-j<0 || visited[i-j]) return false; //오르막이기 때문에 앞에 크기 확인
                    if(arr[row][i] != arr[row][i-j]) return false; //현재와 다른 높이면 false;
                    visited[i-j] = true;
                }
            }
            else if(diff==1) { //내리막이면
                for(int j=1; j<=L; j++) {
                    if(i+j>=N || visited[i+j]) return false; //내리막이기 때문에 뒤에 크기 확인
                    if(arr[row][i]-1 != arr[row][i+j]) return false; //현재와 다른 높이면 false;
                    visited[i+j] = true;
                }
            }
        }
        return true;
    }//end checkRow

    public static boolean checkCol(int col) {
        visited = new boolean[N];
        for(int i=0; i<N-1; i++) {
            int diff = arr[i][col] - arr[i+1][col];
            if(diff>1 || diff<-1) return false; //높이 차이가 1이상이면 false
            else if(diff==-1) { //오르막이면
                for(int j=0; j<L; j++) {
                    if(i-j<0 || visited[i-j]) return false; //오르막이기 때문에 앞에 크기 확인
                    if(arr[i][col] != arr[i-j][col]) return false; //현재와 다른 높이면 false;
                    visited[i-j] = true;
                }
            }
            else if(diff==1) { //내리막이면
                for(int j=1; j<=L; j++) {
                    if(i+j>=N || visited[i+j]) return false; //내리막이기 때문에 뒤에 크기 확인
                    if(arr[i][col]-1 != arr[i+j][col]) return false; //현재와 다른 높이면 false;
                    visited[i+j] = true;
                }
            }
        }
        return true;
    }
}