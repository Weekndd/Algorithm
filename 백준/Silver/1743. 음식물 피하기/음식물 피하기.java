import java.io.*;
import java.util.*;

public class Main {  //음식물 피하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[R+1][C+1];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }//end input

        int[] dirX = new int[]{0,0,-1,1};
        int[] dirY = new int[]{-1,1,0,0};
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[R+1][C+1];
        int max = 0;

        for(int r=1; r<=R; r++) {
            for(int c=1; c<=C; c++) {
                int count = 0;
                if(map[r][c] == 0) continue;
                boolean flag = false;
                que.add(new int[]{r,c});
                while(!que.isEmpty()) {
                    int[] location = que.poll();
                    int nowX = location[0];
                    int nowY = location[1];
                    for(int i=0; i<4; i++) {
                        int nextX = nowX + dirX[i];
                        int nextY = nowY + dirY[i];
                        if(nextX <= 0 || nextX > R || nextY <= 0 || nextY > C) {
                            continue;
                        }
                        if(map[nextX][nextY]!=0 && !visited[nextX][nextY]) {
                            flag = true;
                            count++;
                            visited[nextX][nextY] = true;
                            que.add(new int[]{nextX, nextY});
                        }
                    }
                }//end while
                if(!flag) count = 1;
                if(count > max) max = count;
            }
        }
        System.out.println(max);
    }//end main
}