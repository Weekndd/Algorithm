import java.io.*;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            
            int start = startMonth*100+startDay;
            int end = endMonth*100+endDay;
            flowers[i] = new Flower(start, end);
        }//end input;
        Arrays.parallelSort(flowers);
        int startDay = 301;
        int endDay = 1201;
        int max = 0;
        int index = 0;
        int count = 0;
        
        while(startDay < endDay) {
        	boolean isFinded = false;
        	for(int i=index; i<N; i++) {
            	if(flowers[i].start > startDay) {
            		break;
            	}
            	if(max < flowers[i].end) {
            		isFinded = true;
            		max = flowers[i].end;
            		index = i+1;
            	}
            }
        	if(isFinded) {
        		startDay = max;
        		count++;
        	}
        	else {
        		break;
        	}
        }//end while
        if(max < endDay) {
        	System.out.println(0);
        }
        else {
        	System.out.println(count);
        }
        
    }//end main
    
    static class Flower implements Comparable<Flower>{
    	int start;
    	int end;
    	Flower(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    	
    	//1. 시작일 낮은순
    	//2. 종료일 높은순
		@Override
		public int compareTo(Flower f) {
			if(this.start < f.start) {
				return -1;
			}
			else if(this.start == f.start) {
				if(this.end > f.end) {
					return -1;
				}
				else if(this.end == f.end) {
					return 0;
				}
				return 1;
			}
			else {
				return 1;
			}
		}
    	
    }//end flower
}
