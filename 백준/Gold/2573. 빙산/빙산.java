import java.util.*;
import java.io.*;
public class Main { //가방 문제 다시풀기
    static int R;
    static int C;
    static int[] dirX = new int[] {0,0,-1,1};
    static int[] dirY = new int[] {-1,1,0,0};
    static boolean[][] visited;
    static List<int[][]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                int num = Integer.parseInt(st.nextToken());;
                map[i][j] = num;
            }
        }//end input
        list.add(map);

        for(int t=0; t<=10000; t++) {
            int[][] nowMap = list.get(t);
            int[][] nextMap = new int[R][C];
            int count = 0;
            visited = new boolean[R][C];
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(!visited[i][j] && nowMap[i][j]!=0) {
                        dfs(i,j,nowMap);
                        count++;
                    }
                    if(count==2) {
                        System.out.println(t);
                        System.exit(0);
                    }
                }
            }

            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    int height = nowMap[i][j];
                    if(height==0) {
                        nextMap[i][j] = 0;
                        continue;
                    }
                    int sea = 0;
                    for(int k=0; k<4; k++) {
                        int nextRow = dirX[k] + i;
                        int nextCol = dirY[k] + j;
                        if(nextRow<0 || nextRow>=R || nextCol<0 || nextCol>=C) continue;
                        if(nowMap[nextRow][nextCol] == 0) sea++;
                    }//접한 바다면 확인
                    nextMap[i][j] = height-sea < 0 ? 0 : height-sea;
                }
            }

            list.add(nextMap);
        }//end 1년..
        System.out.println(0);
    }//end main

    static public void dfs(int r, int c, int[][] map) {
        visited[r][c] = true;
        for(int i=0; i<4; i++) {
            int nextR = r+dirX[i];
            int nextC = c+dirY[i];
            if(nextR<0 || nextR>=R || nextC<0 || nextC>=C) {
                continue;
            }
            if(!visited[nextR][nextC] && map[nextR][nextC]!=0) {
                dfs(nextR,nextC,map);
            }

        }
    }
}