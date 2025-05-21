import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[][], max, pick[];
    static int taja = 1;
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][10];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //게임 시작
        pick = new int[10];
        visited = new boolean[10];
        pick[4] = 1;
        visited[1] = true;
        permutation(1);
        System.out.println(max);
    }//end main

    public static void permutation(int idx) {
        if(idx==10) {
            int score = 0;
            for(int round=1; round<=N; round++) {
                boolean[] base = new boolean[4];
                int out = 0;
                while(out<3) {
                    taja = taja %10==0 ? 1 : taja %10 ;
                    int hitter = pick[taja++];
                    int hit = arr[round][hitter];

                    //아웃이면
                    if(hit==0) out++;
                    //홈런이면
                    else if(hit==4) {
                        for(int i=1; i<=3; i++) { //주루에 있는 사람 수
                            if(base[i]) score++;
                            base[i] = false;
                        }
                        score++;//홈런 친 사람 포함
                    }
                    //안타면
                    else {
                        for(int i=3; i>=1; i--) {
                            if(!base[i]) continue;
                            else if(i+hit>3) { //주자가 홈에 들어간다면
                                base[i]=false;
                                score++;
                            }
                            else if(i+hit<=3) { //주자가 홈까지는 못간다면
                                base[i+hit] = true;
                                base[i] = false;
                            }
                        }
                        base[hit] = true;
                    }
                }//한 회 종료
            }//게임 끝
            taja = 1;
            max = Math.max(max,score);
            return;
        }

        for(int i=1; i<=9; i++) {
            if(visited[i]) continue;
            if(idx==4) {
                permutation(idx+1);
                return;
            }
            else {
                visited[i] = true;
                pick[idx] = i;
                permutation(idx+1);
                visited[i] = false;
            }
        }
    }//end permutation
}