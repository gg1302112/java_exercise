package com.lzw.java_thread.tickets;

/**
 * @Auther: lzw
 * 使用同步方法，实现共享资源同步
 */
public class RunableTickets2 implements Runnable{
    private int tickets = 10;
    @Override
    public void run() {
        while (tickets>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                this.sale();

        }
    }
    public synchronized void sale(){
        if (tickets>0){
            System.out.println(Thread.currentThread().getName()+" 剩余"+(tickets--)+"张票");
        }
    }

    public static void main(String[] args) {
        RunableTickets2 rtt = new RunableTickets2();
        Thread td1 = new Thread(rtt);
        Thread td2 = new Thread(rtt);
        Thread td3 = new Thread(rtt);
        Thread td4 = new Thread(rtt);
        td1.start();
        td2.start();
        td3.start();
        td4.start();
    }
}
