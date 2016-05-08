package com.example.testsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ClientThread extends Thread{

	BufferedReader bufferR;
	BufferedWriter bufferW;
	Socket client;
	Handler handler;

	public ClientThread(Socket client, Handler handler) {
		this.handler = handler;
		try {
			this.client = client;
			//연결된 소켓으로부터 대화를 나눌 스트림을 얻음
			bufferR = new BufferedReader(new InputStreamReader(client.getInputStream()));
			bufferW = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//보내기
	public void send(String data){
		System.out.println("전송");
		try {
			data="5/15";
			System.out.println("data:"+data);
			bufferW.write(data+"\n");
			bufferW.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//받기
	public void listen(){
		String msg=null;
		try {
			while(true){
				msg=bufferR.readLine();
				
				Log.v("msgtt", msg);
				
				Message m = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("msg", msg);
				m.setData(bundle);
				
				handler.sendMessage(m);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return msg;
	}
	
	public void run() {
		super.run();
		listen();	
	}	
}