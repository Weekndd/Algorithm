import java.util.*;
import java.io.*;
class Main{
    static int N,M,map[][],maximumSafeZone;
    static int[] dirR = new int[] {0,0,-1,1};
    static int[] dirC = new int[] {-1,1,0,0};
    static List<int[]> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num==2) virusList.add(new int[] {i,j});
                map[i][j] = num;
            }
        }
        //end input

        makeWall(new int[] {0,0}, 0);
        System.out.println(maximumSafeZone);
    }//end main
    static public void makeWall(int[] now, int cnt) {
        if(cnt==3) {
            spreadVirus();
            int safeZone = countSafeZone();
            maximumSafeZone = Math.max(maximumSafeZone,safeZone);
            returnMap();
            return;
        }
        int r = now[0], c = now[1];
        for(int i=r; i<N; i++) {
            for(int j=c; j<M; j++) {
                if(map[i][j]==1 || map[i][j]==2) continue;
                map[i][j] = 1;
                makeWall(new int[]{i,j},cnt+1);
                map[i][j] = 0;
            }
            c=0;
        }
    }
    static public void spreadVirus() {
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<virusList.size(); i++) {
            int[] virus = virusList.get(i);
            if(visited[virus[0]][virus[1]]) continue;
            Queue<int[]> que = new LinkedList<>();
            que.offer(virus);
            visited[virus[0]][virus[1]] = true;

            while(!que.isEmpty()) {
                int[] now = que.poll();
                for(int d=0; d<4; d++) {
                    int nr = now[0]+dirR[d];
                    int nc = now[1]+dirC[d];
                    if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                    if(visited[nr][nc] || map[nr][nc]==1) continue;
                    map[nr][nc] = 2;
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc});
                }
            }//end while
        }
    }//end spreadVirus
    static public int countSafeZone() {
        int cnt = 0;
        for(int[] i : map) {
            for(int j : i) {
                if(j==0) cnt++;
            }
        }
        return cnt;
    }
    static public void returnMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==2) {
                    map[i][j]=0;
                }
            }
        }
        for(int i=0; i<virusList.size(); i++) {
            int[] virus = virusList.get(i);
            map[virus[0]][virus[1]] = 2;
        }
    }
}