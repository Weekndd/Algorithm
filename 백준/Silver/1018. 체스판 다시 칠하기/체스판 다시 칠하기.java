import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static int getSolution(int startRow, int startCol, String[] board) {
		String[] orgBoard = {"WBWBWBWB","BWBWBWBW"};
		int whiteSol = 0;
		for(int i=0; i<8; i++) {
			int row = startRow + i;
			for(int j=0; j<8; j++) {
				int col = startCol + j;
				
				if(board[row].charAt(col)!= orgBoard[i%2].charAt(j)) {
					whiteSol++;
				}
			}
		}
		return Math.min(whiteSol, 64-whiteSol);
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		String[] board = new String[row];
		for(int i=0; i<row; i++) {
			board[i] = br.readLine();
		}
		
		int sol = Integer.MAX_VALUE;
		for(int i=0; i<=row-8; i++) {
			for(int j=0; j<=col-8; j++) {
				int curSol = getSolution(i, j, board);
				if(sol>curSol) {
					sol = curSol;
				}
			}
		}
		System.out.println(sol);
		
		
	}
}