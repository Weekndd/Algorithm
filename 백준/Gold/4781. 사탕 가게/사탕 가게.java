import java.util.*;
import java.io.*;

class Main {
	static class Candy {
		int kcal;
		int price;
		Candy(int kcal, int price) {
			this.kcal = kcal;
			this.price = price;
		}
	}
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	while(true) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(st.nextToken()); //사탕 종류
    		double K = Double.parseDouble(st.nextToken()); //가진 돈
    		if(N==0 && K==0.00) break;
    		Candy[] candies = new Candy[N+1];
    		for(int i=1; i<=N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int kcal = Integer.parseInt(st.nextToken()); //사탕 종류
    			double price = Double.parseDouble(st.nextToken()); //가진 돈
    			candies[i] = new Candy(kcal, (int) Math.round(price * 100)); // 정확한 변환
    		}
    		
    		int[]dp = new int[(int)(K*100)+1];
    		dp[0] = 0;
    		
    		for(int i=1; i<=N; i++) {
    			int kcal = candies[i].kcal;
    			int price = candies[i].price;
    			for(int j=price; j<=(int)(K*100); j++) {
    				dp[j] = Math.max(dp[j],dp[j-price]+kcal);
    			}
    		}
    		sb.append(dp[(int)(K*100)]+"\n");
    	}
    	System.out.println(sb);
    	
    }//end main
}