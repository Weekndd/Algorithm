import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Integer>[] wheels;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new LinkedList[4+1];
        for(int i=1; i<=4; i++) {
            wheels[i] = new LinkedList<>();
            String str = br.readLine();
            for(int j=0; j<8; j++) {
                wheels[i].add(Integer.parseInt(String.valueOf(str.charAt(j))));
            }
        }
        //end input

        //N번만큼 회전
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            rotateFront(num, dir);
            rotateBack(num,dir);
            rotateWheel(num, dir);
        }
        int score = countScore();
        System.out.println(score);
    }//end main
    static public void rotateFront(int num, int dir) {
        int preTooth = wheels[num].get(6);

        for(int i=num-1; i>=1; i--) {
            LinkedList<Integer> nowWheel = wheels[i];
            int nowTooth =  nowWheel.get(2);
            if(nowTooth == preTooth) return;

            dir*=-1;
            preTooth = nowWheel.get(6);
            rotateWheel(i,dir);
        }
    }

    static public void rotateBack(int num, int dir) {
        int preTooth = wheels[num].get(2);

        for(int i=num+1; i<=4; i++) {
            LinkedList<Integer> nowWheel = wheels[i];
            int nowTooth =  nowWheel.get(6);
            if(nowTooth == preTooth) return;

            dir*=-1;
            preTooth = nowWheel.get(2);
            rotateWheel(i,dir);
        }
    }

    static public void rotateWheel(int wheelNum, int dir) {
        LinkedList<Integer> nowWheel = wheels[wheelNum];
        if(dir==1) {
            nowWheel.addFirst(nowWheel.get(nowWheel.size()-1));
            nowWheel.removeLast();
        }
        else if(dir==-1) {
            nowWheel.addLast(nowWheel.get(0));
            nowWheel.removeFirst();
        }
    }
    static public int countScore() {
        int score = 0;
        if(wheels[1].get(0)==1) score+=1;
        if(wheels[2].get(0)==1) score+=2;
        if(wheels[3].get(0)==1) score+=4;
        if(wheels[4].get(0)==1) score+=8;
        return score;
    }
}