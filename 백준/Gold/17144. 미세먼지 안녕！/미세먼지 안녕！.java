import java.util.*;
import java.io.*;

public class Main {
    static int[] cleaner = new int[2];
    static int R, C, T, arr[][];
    static int[] dirR = new int[]{0,1,0,-1};
    static int[] dirC = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        int idx = 0;
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == -1) {
                    cleaner[idx++] = i;
                }
            }
        }
        //end input

        for(int i=0; i<T; i++) {
            arr = spread();
            arr = clean();
        }
        int ans = 0;
        for(int[] i : arr) {
            for(int j : i) {
                if(j == -1) continue;
                ans += j;
            }
        }
        System.out.println(ans);
    }//end main
    static public int[][] spread() {
        int[][] newArr = new int[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j]==0) continue;
                if(arr[i][j]==-1) {
                    newArr[i][j] = -1;
                    continue;
                }

                int cnt = 0; //확산되는 칸의 수
                for(int d=0; d<4; d++) {
                    int nr = i+dirR[d];
                    int nc = j+dirC[d];
                    if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                    if(arr[nr][nc]==-1) continue;
                    newArr[nr][nc] += arr[i][j]/5;
                    if(newArr[nr][nc]<0) newArr[nr][nc]=0; //미세먼지가 다 없어진 경우 0으로
                    cnt++;
                }
                newArr[i][j] += arr[i][j]-(arr[i][j]/5)*cnt;
            }
        }
        return newArr;
    }//end spread

    static public int[][] clean() {
        int[][] newArr = new int[R][C];
        for(int i=0; i<R; i++) {
            newArr[i] = Arrays.copyOf(arr[i],C);
        }
        newArr[cleaner[0]][0]=-1;
        newArr[cleaner[1]][0]=-1;
        
        //아래쪽 청소
        int row = cleaner[1];
        int col = 1;
        newArr[row][col] = 0;
        int next = arr[row][col];
        for(int d=0; d<4; d++) {
            while(true) {
                row += dirR[d];
                col += dirC[d];
                if(row<0 || row>=R || col<0 || col>=C) {
                    row -=dirR[d];
                    col -=dirC[d];
                    break;
                }
                if(arr[row][col] == -1) break;
                newArr[row][col] = next;
                next = arr[row][col];
            }
        }
        
        //위쪽 청소
        row = cleaner[0];
        col = 1;
        newArr[row][col] = 0;
        next = arr[row][col];
        for(int d=0; d<4; d++) {
            while(true) {
                row += dirR[d]*-1;
                col += dirC[d];
                if(row<0 || row>=R || col<0 || col>=C) {
                    row -=dirR[d]*-1;
                    col -=dirC[d];
                    break;
                }
                if(arr[row][col] == -1) break;
                newArr[row][col] = next;
                next = arr[row][col];
            }
        }
        return newArr;
    }
}