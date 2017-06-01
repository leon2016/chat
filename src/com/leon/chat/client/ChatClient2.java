package com.leon.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.leon.chat.thread.ChatReadThread;
import com.leon.chat.thread.ChatWriterThread;

public class ChatClient2 {
    public static void main(String[] args) throws Exception, Exception {
        
        String serverIP  = "127.0.0.1";
        // 链接sever端
        Socket s1 = new Socket(serverIP, 8888);
        // 实例化输入流
        DataInputStream dis = new DataInputStream(s1.getInputStream());
        // 实例化输出流
        DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
        // 实例化两个进程
        Thread chatReadThread = new ChatReadThread(dis,"服务器"+serverIP);
        Thread chatWriterTread = new ChatWriterThread(dos);
        // 启动两个进程
        chatReadThread.start();
        chatWriterTread.start();
    }
}
