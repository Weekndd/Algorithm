import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) break;
			char pre = '-';
			int aCnt = 0;
			int bCnt = 0;
			boolean flag = false;
			boolean aFlag = false;
			boolean bFlag = false;
			for(int i=0; i<str.length(); i++) {
				char now = str.charAt(i);
				if(now=='a' || now=='e' || now=='i' || now=='o' || now=='u') {
					aCnt++;
					bCnt = 0;
					flag = true;
				}
				else {
					bCnt++;
					aCnt = 0;
				}
				if(aCnt==3 || bCnt==3) {
					aFlag = true;
					break;
				}
				if(now==pre) {
					if(now=='e' || now=='o') continue;
					bFlag = true;
				}
				pre = now;
			}
			if(!flag || aFlag || bFlag) sb.append("<"+str+"> is not acceptable.\n");
			else sb.append("<"+str+"> is acceptable.\n");
		}//end while
		System.out.println(sb);
		
	}//end main
}