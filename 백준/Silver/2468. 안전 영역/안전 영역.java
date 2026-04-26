import java.util.*;
import java.io.*;
public class Main { //가방 문제 다시풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int height = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                height = height < num ? num : height;
                map[i][j] = num;
            }
        }//end input

        int ans = 1;
        int[] dirX = new int[] {-1,1,0,0};
        int[] dirY = new int[] {0,0,-1,1};

        for(int h=1; h<height; h++) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j]>h) {
                        Queue<int[]> que = new LinkedList<>();
                        que.offer(new int[] {i,j});
                        visited[i][j] = true;
                        while(!que.isEmpty()) {
                            int[] location = que.poll();
                            int nowX = location[0];
                            int nowY = location[1];

                            for(int k=0; k<4; k++) {
                                int nextX = nowX + dirX[k];
                                int nextY = nowY + dirY[k];
                                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                                    continue;
                                }
                                if(map[nextX][nextY] > h && !visited[nextX][nextY]) {
                                    visited[nextX][nextY] = true;
                                    que.offer(new int[]{nextX,nextY});
                                }
                            }
                        }//end while
                        count++;
                    }
                }
            }
            ans = count > ans ? count : ans;
        }//end height
        System.out.println(ans);
    }//end main
}