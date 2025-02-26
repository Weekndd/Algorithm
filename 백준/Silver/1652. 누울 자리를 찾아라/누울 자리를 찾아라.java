import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
		
        for (int i=0; i<N; i++) {
        	map[i] = br.readLine().toCharArray();
        }
		
        int row = 0;
        int col = 0;
        int temp = 0;
		
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(map[i][j] == '.') {
                	temp++;
                    if (temp == 2) row++;
                }
                else temp = 0;
            }
            temp = 0;
        }
		
        temp = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(map[j][i] == '.') {
                    temp++;
                    if(temp == 2) col++;
                } 
                else temp = 0;
            }
            temp = 0;
        }
        System.out.println(row + " " + col);
    }
}