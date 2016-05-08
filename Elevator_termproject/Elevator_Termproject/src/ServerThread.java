import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;


public class ServerThread extends Thread{
	Socket client;
	BufferedReader buffer;
	BufferedWriter bufferWriter;
	Vector<ServerThread> connectList;
	ArrayList<elevator> allele;
	ArrayList<Businessman> allMan;

	public int[] floor_count;
	
	MainFrame hf;
	
	int upAnddown1 = 0;
	int upAnddown2 = 0;
	int upAnddown3 = 0;
	int upAnddown4 = 0;
	int checkpause1 = 0;
	int checkpause2 = 0;
	int checkpause3 = 0;
	int checkpause4 = 0;
	public ServerThread(Vector<ServerThread> connectList, Socket socket, MainFrame hf,  ArrayList<elevator> allele, ArrayList<Businessman> allMan,
			int[] floor_count) {
		this.connectList = connectList;
		this.client = socket; 
		this.hf=hf;
		this.allele = allele;
		this.allMan = allMan;
		this.floor_count = floor_count;
		
		try {
			buffer = new BufferedReader(new InputStreamReader((client.getInputStream())));
			bufferWriter = new BufferedWriter(new OutputStreamWriter((client.getOutputStream())));
		} catch (IOException e) {
			System.out.println("catch"); 
			e.printStackTrace();
		}
	}

	public void run() {
		//System.out.println("run");
		new ServerThreadListen(buffer, allMan, floor_count).start();
		
		while(true){
			//System.out.println("run2");
			//String msg = listen();//여기서부터 다음으로안넘어감.여기는항상듣는걸 기다리고있는 while문 보내는쪽이랑 다르게구현해야되는듯.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(allele.get(0).getUp()){
				upAnddown1=1;
			}else
				upAnddown1=0;
			
			if(allele.get(1).getUp()){
				upAnddown2=1;
			}else
				upAnddown2=0;
			
			if(allele.get(2).getUp()){
				upAnddown3=1;
			}else
				upAnddown3=0;
			
			if(allele.get(3).getUp()){
				upAnddown4=1;
			}else
				upAnddown4=0;
			
			if(allele.get(0).getD_x()==allele.get(0).getY())
				checkpause1=1;
			else 
				checkpause1=0;
			
			if(allele.get(1).getD_x()==allele.get(1).getY())
				checkpause2=1;
			else 
				checkpause2=0;
			
			if(allele.get(2).getD_x()==allele.get(2).getY())
				checkpause3=1;
			else 
				checkpause3=0;
			
			if(allele.get(3).getD_x()==allele.get(3).getY())
				checkpause4=1;
			else 
				checkpause4=0;
			
			send(hf.getnumOfWaiting()+"/"+Long.toString(hf.getavg_time())+"/"+
			Integer.toString(upAnddown1)+"/"+(600-allele.get(0).getY())/30+"/"+hf.getboardingPeople1()+"/"+hf.getelevWeight1()+"/"+
			Integer.toString(upAnddown2)+"/"+(600-allele.get(1).getY())/30+"/"+hf.getboardingPeople2()+"/"+hf.getelevWeight2()+"/"+
			Integer.toString(upAnddown3)+"/"+(600-allele.get(2).getY())/30+"/"+hf.getboardingPeople3()+"/"+hf.getelevWeight3()+"/"+
			Integer.toString(upAnddown4)+"/"+(600-allele.get(3).getY())/30+"/"+hf.getboardingPeople4()+"/"+hf.getelevWeight4()
			);
		}
	}

	//메시지 전송
	//데이터 바뀔때마다 가져와서 보내야한다. 메시지 형식으로.
	public void send(String msg){
		try {
			
			for(int i=0;i<connectList.size();i++){
				ServerThread st = connectList.get(i);
				st.bufferWriter.write(msg+"\n");
			
				st.bufferWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
