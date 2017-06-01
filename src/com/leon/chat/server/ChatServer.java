package com.leon.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.leon.chat.thread.ChatReadThread;
import com.leon.chat.thread.ChatWriterThread;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        
        System.out.println("服务器启动,等待用户连接...");
        // 设置sever端的链接
        ServerSocket s = new ServerSocket(8888);
        Socket s1 = s.accept();// sever等待链接
        String clientIP = s1.getInetAddress().getHostAddress();
        System.out.println(clientIP+"上线了");
        // 实例化输入流
        DataInputStream dis = new DataInputStream(s1.getInputStream());
        // 实例化输出流
        DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
        // 实例化两个线程的对象
        Thread chatReadThread = new ChatReadThread(dis,clientIP);
        Thread chatWriterThread = new ChatWriterThread(dos);
        // 启动线程
        chatReadThread.start();
        chatWriterThread.start();
    }
}
