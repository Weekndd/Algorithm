import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static int max = 0;
    static int[] dirR = new int[] {0,0,-1,1};
    static int[] dirC = new int[] {-1,1,0,0};
    static char[][] board;
    static boolean visited[];

    public static void main(String[] args) throws IOException { //테트로미노
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i=0; i<R; i++) {
            board[i] = br.readLine().toCharArray();
        }//end input
        visited = new boolean[26];

        dfs(0,0,1);
        System.out.println(max);
    }//end main
    public static void dfs(int r, int c, int depth) {
        visited[board[r][c]-65] = true;
        if(depth>max) max = depth;
        for(int i=0; i<4; i++) {
            int nextR = r + dirR[i];
            int nextC = c + dirC[i];
            if(nextR<0 || nextR>=R || nextC<0 || nextC>=C) {
                continue;
            }
            char nextAlp = board[nextR][nextC];
            if(!visited[nextAlp-65]) {
                dfs(nextR,nextC,depth+1);
                visited[nextAlp-65] = false;
            }
        }
    }//end dfs
}