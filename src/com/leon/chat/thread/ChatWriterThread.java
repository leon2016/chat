package com.leon.chat.thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatWriterThread extends Thread {
    private DataOutputStream dos;

    public ChatWriterThread(DataOutputStream dos) {
        this.dos = dos;
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        try {
            while (true) {
                msg = br.readLine();
                dos.writeUTF(msg);
                if (msg.equals("bye")) {
                    System.out.println("自己下线,程序退出");
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
