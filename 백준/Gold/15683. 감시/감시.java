import java.util.*;
import java.io.*;

public class Main {
    static int[] dirR = new int[]{0,-1,0,1};
    static int[] dirC = new int[]{1,0,-1,0};
    static int N,M,arr[][], minDeadzone;
    static List<int[]> cctvList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        cctvList = new ArrayList<>();
        minDeadzone = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]!=0 && arr[i][j]!=6) cctvList.add(new int[]{i,j});
            }
        }
        rotate(0,arr);
        System.out.println(minDeadzone);
    }//end main

    public static void rotate(int cnt, int[][] originArr) {
        if(cnt==cctvList.size()) {
            int deadZone = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(originArr[i][j]==0) {
                        deadZone++;
                    }
                }
            }
            minDeadzone = Math.min(deadZone, minDeadzone);
            return;
        }

        int[][] newArr = new int[N][M];
        newArr = rollbackMap(newArr, originArr);

        int[] now = cctvList.get(cnt);
        int r = now[0];
        int c = now[1];
        int type = arr[now[0]][now[1]];

        for(int k=0; k<4; k++) {
            int d = k;
            if(type==1) {
                watch(r,c,d,newArr);
                rotate(cnt+1,newArr);
                newArr = rollbackMap(newArr, originArr);
            }//end type 1

            else if(type==2) {
                for(int i=0; i<3; i+=2) {
                    watch(r,c,(k+i)%4,newArr);
                }
                rotate(cnt+1,newArr);
                newArr = rollbackMap(newArr, originArr);
            }//end type 2

            else if(type==3) {
                for(int i=0; i<2; i++) {
                    watch(r,c,(k+i)%4,newArr);
                }
                rotate(cnt+1,newArr);
                newArr = rollbackMap(newArr, originArr);
            }//end type 3

            else if(type==4) {
                for(int i=0; i<3; i++) {
                    watch(r,c,(k+i)%4,newArr);
                }
                rotate(cnt+1,newArr);
                newArr = rollbackMap(newArr, originArr);
            }//end type 4

            else if(type==5) {
                for(int i=0; i<4; i++) {
                    watch(r,c,(k+i)%4,newArr);
                }
                rotate(cnt+1,newArr);
                newArr = rollbackMap(newArr, originArr);
                break;
            }//end type 4
        }

    }//end rotate
    static public int[][] rollbackMap(int[][] arr, int[][] originArr) {
        for(int i=0; i<N; i++) {
            arr[i] = Arrays.copyOf(originArr[i], M);
        }
        return arr;
    }

    static public void watch(int r, int c, int d, int[][] newArr) {
        int dis = 1;
        while(true) {
            int nr = r+dirR[d]*dis;
            int nc = c+dirC[d]*dis;
            if(nr<0 || nr>=N || nc<0 || nc>=M) break;
            if(arr[nr][nc] == 6) break;
            dis++;
            if(arr[nr][nc]!=0) continue;
            newArr[nr][nc] = 9;
        }
    }
}