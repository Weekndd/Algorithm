import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] arr,divArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }//end input
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++) {
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) arr = A();
            else if (command == 2) arr = B();
            else if (command == 3) arr = C();
            else if (command == 4) arr = D();
            else if (command == 5) arr= divA();
            else if (command == 6) arr = divB();
        }
        StringBuilder sb = new StringBuilder();
	    for(int[] i : arr) {
	        for(int j : i) sb.append(j+" ");
	        sb.append("\n");
	    }
	    System.out.println(sb);
    }//end main

	static public int[][] A() { //상하반전
	    int[][] temp = new int[N][M];
	    for(int i=N-1; i>=0; i--) {
	        for(int j=0; j<M; j++) {
	            temp[(N-1)-i][j] = arr[i][j];
	        }
	    }
	    return temp;
	}
	
	static public int[][] B() { //좌우반전
	    int[][] temp = new int[N][M];
	    for(int i=0; i<N; i++) {
	        for(int j=M-1; j>=0; j--) {
	            temp[i][(M-1)-j] = arr[i][j];
	        }
	    }
	    return temp;
	}
	
	static public int[][] C() { //오른쪽 90도 회전
	    int[][] spinArr = new int[M][N];
	    for(int i=0; i<M; i++) {
	        for(int j=N-1; j>=0; j--) {
	            spinArr[i][(N-1)-j] = arr[j][i];
	        }
	    }
	    int temp = N;
	    N = M;
	    M = temp;
	    return spinArr;
	}
	
	static public int[][] D() { //왼쪽 90도 회전
	    int[][] spinArr = new int[M][N];
	    for(int i=M-1; i>=0; i--) {
	        for(int j=0; j<N; j++) {
	            spinArr[(M-1)-i][j] = arr[j][i];
	        }
	    }
	    int temp = N;
	    N = M;
	    M = temp;
	    return spinArr;
	}
	
	static public int[][] divA() {
	    int rowSize = N/2;
	    int colSize = M/2;
	    divArr = new int[N][M];
	    div(0,0, 0,colSize); //좌상단 -> 우상단
	    div(0, colSize, rowSize, colSize); //우상단 -> 우하단
	    div(rowSize,colSize,rowSize,0); //우하단 -> 좌하단
	    div(rowSize,0,0,0); //좌하단 -> 좌상단
	    return divArr;
	}
	
	static public int[][] divB() {
	    int rowSize = N/2;
	    int colSize = M/2;
	    divArr = new int[N][M];
	    div(0,0, rowSize,0); //좌상단 -> 좌하단
	    div(rowSize, 0, rowSize, colSize); //좌하단 -> 우하단
	    div(rowSize,colSize,0,colSize); //우하단 -> 우상단
	    div(0,colSize,0,0); //우상단 -> 좌상단
	    return divArr;
	}
	static public void div(int findR, int findC, int targetR, int targetC) { //나눈 구역 90도 회전
	    int r = targetR;
	    int c;
	    for(int i=findR; i<findR+(N/2); i++) {
	        c= targetC;
	        for(int j=findC; j<findC+(M/2); j++) {
	            int num = arr[i][j];
	            divArr[r][c] = num;
	            c++;
	        }
	        r++;
	    }
	}
}

