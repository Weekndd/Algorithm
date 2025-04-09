import java.io.*;
import java.util.*;
class Main {
    static int N,M, ans;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<int[]> chicken, house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
                arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(num == 2) chicken.add(new int[]{i,j});
                else if(num == 1) house.add(new int[]{i,j});
            }
        }
        //end input

        ans = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        backtracking(0,0);
        System.out.println(ans);
    }//end main

    static public void backtracking(int s, int depth) {
        if(depth == M) {
            int res = 0;
            for(int i=0; i<house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for(int j=0; j< chicken.size(); j++) {
                    if(visited[j]) {
                        int distance = Math.abs(chicken.get(j)[0] - house.get(i)[0])
                                + Math.abs(chicken.get(j)[1] - house.get(i)[1]);
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans,res);
            return;
        }
        //백트래킹
        for(int i=s; i<chicken.size(); i++) {
            visited[i] = true;
            backtracking(i+1,depth+1);
            visited[i] = false;
        }
    }//end func

}
