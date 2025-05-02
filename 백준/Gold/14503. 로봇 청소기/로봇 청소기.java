import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[] {-1,0,1,0};
    static int[] dy = new int[] {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int robotR = Integer.parseInt(st.nextToken());
        int robotC = Integer.parseInt(st.nextToken());
        int robotD = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {robotR,robotC,robotD});
        map[robotR][robotC] = 3;
        int cnt = 1;

        loop:
        while(!que.isEmpty()) {
            int[] location = que.poll();
            boolean flag = false;

            for(int i=0; i<4; i++) {
                int nextR = location[0] + dx[i];
                int nextC = location[1] + dy[i];

                if(nextR<0 || nextR>=N || nextC<0 || nextC>=M) continue;
                if(map[nextR][nextC]==0) { //주변에 청소할 수 있는 공간이 있으면
                    robotD = robotD-1<0 ? 3 : robotD-1; //반시계로 90도 돌림
                    int frontR = location[0] + dx[robotD];
                    int frontC = location[1] + dy[robotD];

                    if(map[frontR][frontC]!=0) { //바라보는 방향이 청소가 필요하지 않다면
                        while(map[frontR][frontC]!=0) {//바라보는 방향이 청소가 필요한 곳일 때까지 반시계로 돌림
                            robotD = robotD-1<0 ? 3 : robotD-1; //반시계로 90도 돌림
                            frontR = location[0] + dx[robotD];
                            frontC = location[1] + dy[robotD];
                        }
                    }
                    que.offer(new int[] {frontR, frontC, robotD});
                    map[frontR][frontC] = 2;
                    flag = true;
                    cnt++;
                    break;
                }
            }//end 사방탐색
            if(!flag) { //주변에 청소할 곳이 없다면
                //현재 방향에서 뒤로 한칸 이동
                int backR = location[0] + dx[robotD]*-1;
                int backC = location[1] + dy[robotD]*-1;
                if(backR<0 || backR>=N || backC<0 || backC>=M) break loop;
                if(map[backR][backC]==1) break loop;
                que.offer(new int[] {backR,backC,robotD});
            }
        }//end while
        System.out.println(cnt);
    }//end main
}