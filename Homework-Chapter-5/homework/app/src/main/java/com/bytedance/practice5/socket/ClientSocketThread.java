package com.bytedance.practice5.socket;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

public class ClientSocketThread extends Thread {
    public ClientSocketThread(SocketActivity.SocketCallback callback) {
        this.callback = callback;
    }

    private SocketActivity.SocketCallback callback;

    //head请求内容
    private static String content = "HEAD / HTTP/1.1\r\nHost:www.zju.edu.cn\r\n\r\n";


    @Override
    public void run() {
        // TODO 6 用socket实现简单的HEAD请求（发送content）
        //  将返回结果用callback.onresponse(result)进行展
        try {
            Socket socket = new Socket("www.zju.edu.cn", 80);

            BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream is = new BufferedInputStream(socket.getInputStream());


            byte[] data = new byte[1024 * 5];
            while (socket.isConnected()) {
                if (!content.isEmpty()) {
                    os.write(content.getBytes());
                    os.flush();
                    int receiveLen = is.read(data);
                    if (receiveLen!=-1){
                        String receive = new String(data, 0, receiveLen);
                        callback.onResponse(receive);

                    }

                }

                sleep(1000);
            }

            os.flush();
            os.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
