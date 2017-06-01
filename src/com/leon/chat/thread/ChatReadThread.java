package com.leon.chat.thread;

import java.io.DataInputStream;
import java.io.IOException;
/**
 * 
* @ClassName: ChatReadThread 
* @Description: 接受消息的线程
* @author wangang 
*
 */
public class ChatReadThread extends Thread {
    private DataInputStream dis;
    private String sender;
    public ChatReadThread(DataInputStream dis) {
        this.dis = dis;
    }
    public ChatReadThread(DataInputStream dis,String sender) {
        this.dis = dis;
        this.sender = sender;
    }
    public void run() {
        String msg;
        try {
            while (true) {
                msg = dis.readUTF();
                System.out.println(sender+":" + msg);
                if (msg.equals("bye")) {
                    System.out.println(sender+"下线,程序退出");
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
