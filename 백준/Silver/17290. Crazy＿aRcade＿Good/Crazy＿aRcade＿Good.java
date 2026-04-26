import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[10][10];
        for(int i=0; i<10; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
        List<Integer>rowList = new ArrayList<>();
        List<Integer>colList = new ArrayList<>();
        loop:
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {//열 검사
                if(map[i][j]=='o') continue loop;
            }
            rowList.add(i);
        }
        loop:
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {//행 검사
                if(map[j][i]=='o') continue loop;
            }
            colList.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i : rowList) {
            for(int j : colList) {
                int dis = Math.abs((R-1)-i) + Math.abs((C-1)-j);
                ans = Math.min(ans,dis);
            }
        }
        System.out.println(ans);
    }//end main
}