package com.example.testsocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	Button btn;
	TextView textView, textViewtest, textViewtest2; 
	EditText editText;
	Button btn_send;
	
	Socket client;
	//String ip = "192.168.43.198";
	String ip = "192.168.43.198"; 
	int port = 7777;
	
	Thread thread;
	
	ClientThread clientThread;
	
	Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//처음 앱을 키는순간 클라리언트는 서버에 접속메시지를 보내야 한다.
		
		textViewtest = (TextView)findViewById(R.id.bottomtxt2);
		textViewtest2 = (TextView)findViewById(R.id.bottomtxt11);
		btn_send = (Button)findViewById(R.id.btn_send);
		btn_send.setOnClickListener(this);

		handler = new Handler(){
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				Bundle bundle = msg.getData();
				String[] info = bundle.getString("msg").split("/");
				//전체 웨이팅 피플, 평균 웨이팅 타임, (elev(1,2,3,4) up and down, 몇층, 몇명타고있는지, 몇키로인지)
				textViewtest.setText(bundle.getString("msg"));
				//connect()로 연결 후, 메시지처리는 이곳에서 한다. 메시지가 이리로 넘어오면 처리해주는 코드 넣어야 한다.
			}
		};
		connect();
		
		/*
		btn = (Button)findViewById(R.id.btn);
		textView = (TextView)findViewById(R.id.textView);
		editText = (EditText)findViewById(R.id.editText);
		btn_send = (Button)findViewById(R.id.btn_send);
	
		handler = new Handler(){
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				Bundle bundle = msg.getData();
				textView.append(bundle.getString("msg")+"\n");
				
			}
		};
		
		btn.setOnClickListener(this);
		btn_send.setOnClickListener(this);*/
	}
	
	public void connect(){
		
		thread = new Thread(){
			public void run() {
				super.run();
				try {
					System.out.println(ip +" " + port+" "+"22");
					client = new Socket(ip, port);
					System.out.println(ip +" " + port);
					clientThread = new ClientThread(client, handler);
					clientThread.start();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		thread.start();
	}
	
	@Override
	public void onClick(View v) {
		Log.v("msgtt", "tt");
		if(v.getId()==R.id.btn_send){
			Log.v("msgtt", "ee");
			clientThread.send(textViewtest2.getText().toString());
			//editText.setText("");
		}
	}
}