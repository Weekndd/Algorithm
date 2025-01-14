import java.util.*;
import java.io.*;

class Main {
	static int N, K, cnt, arr[][];
	static boolean[] robbot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[2][N];
        robbot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2; i++) {
        	if(i==0) {
        		for(int j=0; j<N; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}	
        	}
        	else {
        		for(int j=N-1; j>=0; j--) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        }
        int ans = 0;
        while(true) {
        	if(cnt>=K) break;
        	moveBelt();
        	moveRobbot();
        	ans++;
        }
        System.out.println(ans);
    }//end main
    
    static void moveBelt() {
    	int temp = arr[0][N-1];
    	for(int i=N-1; i>=1; i--) {
    		arr[0][i] = arr[0][i-1];
    	}
    	arr[0][0] = arr[1][0];
    	for(int j=0; j<N-1; j++) {
    		arr[1][j] = arr[1][j+1];
    	}
    	arr[1][N-1] = temp;
    	//컨베이어 벨트 이동에 따른 로봇 위치 변경
    	for(int i=N-1; i>0; i--) {
    		robbot[i]=robbot[i-1];
    	}
    	robbot[0] = false; //맨 앞 로봇 이동처리
    	if(robbot[N-1]) robbot[N-1] = false; //맨 뒤 로봇 바로 하차
    }//end moveBelt
    
    static void moveRobbot() {
    	
    	for(int i=N-2; i>=0; i--) {
    		if(robbot[i] && !robbot[i+1] && arr[0][i+1]>0) {
    			arr[0][i+1]--;
				if(arr[0][i+1]==0) cnt++;
				robbot[i+1] = robbot[i];
				robbot[i] = false;
    		}
    	}
    	//맨 뒤 로봇 바로 하차
    	robbot[N-1] = false;
    	//로봇 상차
    	if(!robbot[0] && arr[0][0]>0) {
    		robbot[0] = true;
    		arr[0][0]--;
    		if(arr[0][0] == 0) cnt++;
    	}
    }
}