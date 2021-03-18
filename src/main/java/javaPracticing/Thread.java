package javaPracticing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

class StopWatch {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("press any key");
        br.readLine();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = format.format(date.getTime());

        System.out.println("시작 시간 : "+startTime);
        System.out.println("\n");

        CheckTime checkTime = new CheckTime();
        Thread thread = new Thread(checkTime);
        thread.start();

        System.out.println("stop with and key");
        br.readLine();

        thread.interrupt();
        System.out.println("\n");

        String endTime = format.format(date.getTime());
        System.out.println("종료 시간 : "+ endTime);
    }
}

class CheckTime implements Runnable{

    long start;
    long dif;

    @Override
    public void run(){
        try{
            start = System.currentTimeMillis();
            while(!Thread.currentThread().isInterrupted()){
                Thread.sleep(1000);
                // 스레드가 일시 정지되는 시점이 있어야 interrupt 된다.
                // 스레드가 interrupt 되더라도, 사실은 자원이 남아 계속 진행되다가, sleep을 만났을 때야 비로소 종료되기 때문이다.

                dif = System.currentTimeMillis()-start;
                System.out.print("\r"+makeForm(dif/1000));
            }
        }catch (InterruptedException e){
        }
    }

    String makeForm(long whileTime){
        long min = whileTime / 60;
        long hour = min / 60;
        long sec = whileTime % 60;
        min = min % 60;

        String r = hour + " : " + min + " : "+ sec;
        return r;
    }
}
