import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class ServerThreadListen extends Thread{

	BufferedReader buffer;
	ArrayList<Businessman> allMan;
	String[] arr;

	public int[] floor_count;
	
	public ServerThreadListen(BufferedReader buffer, ArrayList<Businessman> allMan, int[] floor_count){
		this.buffer = buffer;
		this.allMan = allMan;
		this.floor_count=floor_count;
	}
	public void run(){
		while(true){
			listen();
		}
	}
	
	public String listen(){
		String msg="";
		try {
			msg= buffer.readLine();
			System.out.println("msg:"+msg);
			//현재층과 목적지층 구분. 현재층/목적지층.
			arr = msg.split("/");
			int a = Integer.parseInt(arr[0]);
			int des = 600-(Integer.parseInt(arr[1].trim())*30);
			
			Businessman Person = new Businessman(400-(floor_count[a] * 30), des, 50);
			Person.setY(600-(a)*30);
			Person.setPri(0);
			Person.setDone(true);
			floor_count[a]++;
			allMan.add(Person);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return msg;
	}
}
