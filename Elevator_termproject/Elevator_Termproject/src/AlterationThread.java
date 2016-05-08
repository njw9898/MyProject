import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

/* This class manages all of our threads
 * When people board or get out 
 * When elevator go up or down
 * When specific times are changed
 */
public class AlterationThread extends Thread{

	MainFrame hf;
	
	ArrayList<Businessman> allMan;
	ArrayList<elevator> allEle;
	ArrayList<Businessman> Man_queue = new ArrayList<Businessman>();
	
	ArrayList<Businessman> floor1 = new ArrayList<Businessman>();//information each floor
	ArrayList<Businessman> floor2 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor3 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor4 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor5 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor6 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor7 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor8 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor9 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor10 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor11 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor12 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor13 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor14 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor15 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor16 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor17 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor18 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor19 = new ArrayList<Businessman>();
	ArrayList<Businessman> floor20 = new ArrayList<Businessman>();
	

	ArrayList<Businessman> ridingOrMan = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan2 = new ArrayList<Businessman>();
	
	ArrayList<Businessman> ridingOrMan11 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan12 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan21 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan22 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan31 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan32 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan41 = new ArrayList<Businessman>();
	ArrayList<Businessman> ridingOrMan42 = new ArrayList<Businessman>();
	
	ArrayList<Businessman> workridingOrMan11 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan12 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan21 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan22 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan31 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan32 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan41 = new ArrayList<Businessman>();
	ArrayList<Businessman> workridingOrMan42 = new ArrayList<Businessman>();
	
	ArrayList<Businessman> homeridingOrMan11 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan12 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan21 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan22 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan31 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan32 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan41 = new ArrayList<Businessman>();
	ArrayList<Businessman> homeridingOrMan42 = new ArrayList<Businessman>();
	
	JPanel jp;
	//integers that used in GUI
	int pri=0;
	int stop_wait=0, stop_wait2=0;
	int max, max1=570, max2=570, max3=570, max4=570;
	int min, min1=0, min2=0, min3=0, min4=0;
	int cnt=0;
	int workmax, workmax1=570, workmax2=570, workmax3=570, workmax4=570;
	int workmin, workmin1=0, workmin2=0, workmin3=0, workmin4=0;
	int homemax, homemax1=270, homemax2=150, homemax3=0, homemax4=570;
	int homemin, homemin1=0, homemin2=0, homemin3=0, homemin4=0;
	Integer select_time;
	
	
	public ArrayList<Businessman> getListAt(int floor){// return each floors information 
		if (floor == 1)
			return floor1;
		else if (floor == 2)
			return floor2;
		else if (floor == 3)
			return floor3;
		else if (floor == 4)
			return floor4;
		else if (floor == 5)
			return floor5;
		else if (floor == 6)
			return floor6;
		else if (floor == 7)
			return floor7;
		else if (floor == 8)
			return floor8;
		else if (floor == 9)
			return floor9;
		else if (floor == 10)
			return floor10;
		else if (floor == 11)
			return floor11;
		else if (floor == 12)
			return floor12;
		else if (floor == 13)
			return floor13;
		else if (floor == 14)
			return floor14;
		else if (floor == 15)
			return floor15;
		else if (floor == 16)
			return floor16;
		else if (floor == 17)
			return floor17;
		else if (floor == 18)
			return floor18;
		else if (floor == 19)
			return floor19;
		else if (floor == 20)
			return floor20;
		return null;
	}
	public AlterationThread(MainFrame hf, ArrayList<Businessman> allMan, ArrayList<elevator> allele, JPanel jp){
		this.allMan = allMan;
		this.allEle = allele; 
		this.jp = jp;
		this.select_time=select_time;
		this.hf = hf;
	}
	public void regularElevator(int whatele, ArrayList ridingOr1, ArrayList ridingOr2, int m, int n){

		
		elevator elevator1 = allEle.get(whatele);
		ridingOrMan=ridingOr1;
		ridingOrMan2=ridingOr2;
		max=m;
		min=n;
			
		// up
		// if(elevator1.getUp()){

		for (int i = 0; i < elevator1.getRidingMan().size(); i++) {
			Businessman tmpMan = elevator1.getRidingMan().get(i);
			if (i == 0) {
				max = tmpMan.getD_y();
				// System.out.println(max);
			}
			if (max > tmpMan.getD_y()) {
				max = tmpMan.getD_y();
			}
			// System.out.println(max);
		}
		for (int i = 0; i < Man_queue.size(); i++) {
			Businessman tmpMan = Man_queue.get(i);
			if (max == 570 && i == 0) {
				max = tmpMan.getY();
			}
			if (max > tmpMan.getY()) {
				max = tmpMan.getY();
			}
		}
	
		for (int i = 0; i < elevator1.getRidingMan().size(); i++) {
			Businessman tmpMan = elevator1.getRidingMan().get(i);
			if (i == 0)
				min = tmpMan.getD_y();
			if (min < tmpMan.getD_y()) {
				min = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < Man_queue.size(); i++) {
			Businessman tmpMan = Man_queue.get(i);
			if (min == 0 && i == 0) {
				min = tmpMan.getY();
			}
			if (min < tmpMan.getY()) {
				min = tmpMan.getY();
			}
		}
		
		
		if(elevator1.getUp()){//////////////////////////up//////////////////
			//System.out.println(max);
			if(max!=570){
				elevator1.setD_y(max);
			}
			int currentFloorOfFirstElev = (600-elevator1.getY()) / 30;
			
			if ((600 - elevator1.getY()) % 30 == 0) {
				ArrayList<Businessman> waitingList = getListAt(currentFloorOfFirstElev);
				
				for(int i=0; i<waitingList.size(); i++){
					Businessman tmpMan = waitingList.get(i);
					
					if((tmpMan.getD_y() < elevator1.getY()) && tmpMan.getRiding()==false &&
							((tmpMan.getWeight()+elevator1.getCurrentweight()) <= elevator1.getLimit())){
						tmpMan.setRiding(true);
						elevator1.setCurrentweight(tmpMan.getWeight()+elevator1.getCurrentweight());
						if(whatele==0)
							tmpMan.setD_x(400+35);
						else if(whatele==1)
							tmpMan.setD_x(400+85);
						else if(whatele==2)
							tmpMan.setD_x(400+135);
						else if(whatele==3)
							tmpMan.setD_x(400+185);
						elevator1.set_flag(true);
						elevator1.set_open(true);
						waitingList.remove(tmpMan);
						elevator1.getRidingMan().add(tmpMan);
						ridingOrMan.add(tmpMan);
					}
				}
				for(int i=0; i<elevator1.getRidingMan().size(); i++){//��������ִ��� Ȯ��.
					
					Businessman tmpMan = elevator1.getRidingMan().get(i);
					//System.out.println(tmpMan.getD_y() +" to "+ elevator1.getY());
					if((tmpMan.getD_y()==elevator1.getY()) && tmpMan.getoffriding()==false){
						tmpMan.setoffriding(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator1.getY());
						elevator1.set_open(true);
						elevator1.setFlag2(true);
						allMan.add(tmpMan);
						ridingOrMan2.add(tmpMan);
					}
				}
				Businessman tmpMan2;
				int check=0;
				int check2=0;
				for(int i=0; i<ridingOrMan.size(); i++){
					  /* each elevator moves again if all waiting people are boarding*/
					tmpMan2=ridingOrMan.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 435) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 485) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 535) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 585) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
				}
				if(check==ridingOrMan.size()&& check!=0){
					
					elevator1.set_flag(false);
					elevator1.set_open(false);
					ridingOrMan.removeAll(ridingOrMan);
				}
				/////////// Until this line is the section people board when elevator go up/////////////
	            
	            /////////// The section people get out from this line  when elevator go up///////////////
				for(int i=0; i<ridingOrMan2.size(); i++){
					//moves again if all people who has the destination of present floor are get out
					tmpMan2=ridingOrMan2.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 500) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 550) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 600) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 650) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
				}
				if(check2==ridingOrMan2.size() && check2!=0){
					elevator1.setFlag2(false);
					elevator1.set_open(false);
					ridingOrMan2.removeAll(ridingOrMan2);
				}
				if(elevator1.get_flag() || elevator1.getFlag2()){
					//jp.repaint();
					return;
				}	
			}
		}
		 /////////// Until this line is the section elevator go up /////////////
	      
	      
	      /////////// The section elevator go down from this line ///////////////
		if(elevator1.getDown()){
			if(min!=0)
				elevator1.setD_y(min);
			int currentFloorOfFirstElev = (600-elevator1.getY()) / 30;
			
			if ((600 - elevator1.getY()) % 30 == 0) {//elevator stop specific floor.
				ArrayList<Businessman> waitingList = getListAt(currentFloorOfFirstElev);
				
				for(int i=0; i<waitingList.size(); i++){//check if waiting people exist or not
					Businessman tmpMan = waitingList.get(i);
					
					if((tmpMan.getD_y() > elevator1.getY()) && tmpMan.getRiding()==false &&
							((tmpMan.getWeight()+elevator1.getCurrentweight()) <= elevator1.getLimit())){
						tmpMan.setRiding(true);
						elevator1.setCurrentweight(tmpMan.getWeight()+elevator1.getCurrentweight());
						if(whatele==0)
							tmpMan.setD_x(400+35);
						else if(whatele==1)
							tmpMan.setD_x(400+85);
						else if(whatele==2)
							tmpMan.setD_x(400+135);
						else if(whatele==3)
							tmpMan.setD_x(400+185);
						elevator1.set_flag(true);
						elevator1.set_open(true);
						waitingList.remove(tmpMan);
						elevator1.getRidingMan().add(tmpMan);
						ridingOrMan.add(tmpMan);
					}
				}
				for(int i=0; i<elevator1.getRidingMan().size(); i++){//check if people who are gotten out are exist.
					
					Businessman tmpMan = elevator1.getRidingMan().get(i);
					//System.out.println(tmpMan.getD_y() +" to "+ elevator1.getY());
					if((tmpMan.getD_y()==elevator1.getY()) && tmpMan.getoffriding()==false){
						tmpMan.setoffriding(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator1.getY());
						elevator1.set_open(true);
						elevator1.setFlag2(true);
						allMan.add(tmpMan);
						ridingOrMan2.add(tmpMan);
					}
				}
				Businessman tmpMan2;
				int check=0;
				int check2=0;
				for(int i=0; i<ridingOrMan.size(); i++){//moves again if all people board.
					tmpMan2=ridingOrMan.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 435) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 485) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 535) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 585) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
				}
				
				if(check==ridingOrMan.size()&& check!=0){
					
					elevator1.set_flag(false);
					elevator1.set_open(false);
					ridingOrMan.removeAll(ridingOrMan);
				}
				/////////// Until this line is the section people board when elevator go down/////////////
	            
	            /////////// The section people get out from this line  when elevator go down///////////////
				for(int i=0; i<ridingOrMan2.size(); i++){
					 //moves again after all people get out
					tmpMan2=ridingOrMan2.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 500) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 550) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 600) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 650) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
				}
				if(check2==ridingOrMan2.size() && check2!=0){
					elevator1.setFlag2(false);
					elevator1.set_open(false);
					ridingOrMan2.removeAll(ridingOrMan2);
				}
				if(elevator1.get_flag() || elevator1.getFlag2()){
					//jp.repaint();
					return;
				}	
			}
		}
		 /////////// Until this line is the section elevator go up /////////////
		for(int i=0; i<allMan.size(); i++){
			Businessman tmpMan = allMan.get(i);
			if(tmpMan.getX()>=920)
				allMan.remove(tmpMan);
		}
		
		//System.out.println(Man_queue.size() + " dd " + elevator1.getRidingMan().size());
		
		if (Man_queue.size() == 0 && elevator1.getRidingMan().size() == 0) {
			min = max = elevator1.getY();
			elevator1.setUp(true);
			elevator1.setDown(true);
										
				elevator1.setD_y(elevator1.getTTLy());
				if(elevator1.getY() > elevator1.getD_y()){
					elevator1.setY(elevator1.getY() - 2);
				}
				if ((elevator1.getY() < elevator1.getD_y())) {
					elevator1.setY(elevator1.getY() + 2);
				}
			
		} else {
			if (elevator1.getY() <= max && elevator1.getUp()) {// select location up and down.
				elevator1.setDown(true);
				elevator1.setUp(false);
			}
			else if (elevator1.getY() >= min && elevator1.getDown()) {
				elevator1.setDown(false);
				elevator1.setUp(true);
			}// System.out.println(min);//////////////////delete///////////
		//}
		if (elevator1.getUp()) {
			if ((elevator1.getY() > elevator1.getD_y())) {
				elevator1.setY(elevator1.getY() - 2);
			}
		}
		if(elevator1.getDown()){
			if ((elevator1.getY() < elevator1.getD_y())) {
				elevator1.setY(elevator1.getY() + 2);
			}
		}
		}
	}
//////////////////////////////////End Normal Time//////////////////////////////////////////
	   
	   
//////////////////////////////////Start Rush hour Time//////////////////////////////////////////
	public void officehour(int whatele, ArrayList ridingOr1, ArrayList ridingOr2, int m, int n){
		
		elevator elevator1 = allEle.get(whatele);
		ridingOrMan=ridingOr1;
		ridingOrMan2=ridingOr2;
		workmax=m;
		workmin=n;
			
		for (int i = 0; i < elevator1.getRidingMan().size(); i++) {
			Businessman tmpMan = elevator1.getRidingMan().get(i);
			if (i == 0) {
				workmax = tmpMan.getD_y();
				// System.out.println(max);
			}
			if (workmax > tmpMan.getD_y()) {
				workmax = tmpMan.getD_y();
			}
		}
		if(elevator1.getUp()){
			 ////////////////////////////the section elevators go up from this line ////////////////////
		
			elevator1.setD_y(workmax);

			int currentFloorOfFirstElev = (600-elevator1.getY()) / 30;
			
			if ((600 - elevator1.getY()) % 30 == 0) {//elevator stop at such floor.
				ArrayList<Businessman> waitingList = getListAt(currentFloorOfFirstElev);
			
				for(int i=0; i<waitingList.size(); i++){//check boarding people.
					Businessman tmpMan = waitingList.get(i);
					
					if (whatele == 0 && currentFloorOfFirstElev == 1) {
						if ((tmpMan.getD_y() >= 270 && tmpMan.getD_y() <= 480)
								&& tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1
										.getCurrentweight()) <= elevator1
										.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
					
								tmpMan.setD_x(400 + 35);//whatele==0
			
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
					else if(whatele==1 && currentFloorOfFirstElev == 1){
						if ((tmpMan.getD_y() >= 150 && tmpMan.getD_y() <= 330)
								&& tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1
										.getCurrentweight()) <= elevator1
										.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
						
							
								tmpMan.setD_x(400 + 85); //whatele==1
						
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
					else if(whatele==2 && currentFloorOfFirstElev == 1){
						if ((tmpMan.getD_y() >= 0 && tmpMan.getD_y() <= 210)
								&& tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1
										.getCurrentweight()) <= elevator1
										.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
						
							tmpMan.setD_x(400+135);//whatele==2
									
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
					else if(whatele==3 && currentFloorOfFirstElev == 1){
						if ((tmpMan.getD_y() >= 150 && tmpMan.getD_y() <= 330)
								&& tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1
										.getCurrentweight()) <= elevator1
										.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
							
									tmpMan.setD_x(400+185);//whatele==2
									
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
				}
				for(int i=0; i<elevator1.getRidingMan().size(); i++){//check getting out people
					
					Businessman tmpMan = elevator1.getRidingMan().get(i);
					//System.out.println(tmpMan.getD_y() +" to "+ elevator1.getY());
					if((tmpMan.getD_y()==elevator1.getY()) && tmpMan.getoffriding()==false){
						tmpMan.setoffriding(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator1.getY());
						elevator1.set_open(true);
						elevator1.setFlag2(true);
						allMan.add(tmpMan);
						ridingOrMan2.add(tmpMan);
					}
				}
				Businessman tmpMan2;
				int check=0;
				int check2=0;
				for(int i=0; i<ridingOrMan.size(); i++){//moves again after all people board
					tmpMan2=ridingOrMan.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 435) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 485) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 535) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 585) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
				}
				if(check==ridingOrMan.size()&& check!=0){//remove information of ridingOrMan after all people board
					
					elevator1.set_flag(false);
					elevator1.set_open(false);
					ridingOrMan.removeAll(ridingOrMan);
				}
				/////////// Until this line is the section elevator go up /////////////

	            /////////// The section people get out from this line  when elevator go down///////////////
				for(int i=0; i<ridingOrMan2.size(); i++){
					tmpMan2=ridingOrMan2.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 500) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 550) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 600) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 650) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
				}
				if(check2==ridingOrMan2.size() && check2!=0){
					elevator1.setFlag2(false);
					elevator1.set_open(false);
					ridingOrMan2.removeAll(ridingOrMan2);
				}
				if(elevator1.get_flag() || elevator1.getFlag2()){
					//jp.repaint();
					return;
				}	
			}
		}
		if(elevator1.getY()==workmax && elevator1.getY()!=570){
			elevator1.setD_y(570);
			elevator1.setDown(true);
			elevator1.setUp(false);
		}
		else if(elevator1.getY()==570){
			elevator1.setUp(true);
			elevator1.setDown(false);
		}
		if (elevator1.getUp()) {
			if ((elevator1.getY() > elevator1.getD_y())) {
				elevator1.setY(elevator1.getY() - 2);
			}
		}
		if(elevator1.getDown()){
			if(elevator1.getY()<elevator1.getD_y()){
				elevator1.setY(elevator1.getY() + 2);
			}
		}
	}
	//////////////////////////////////End Rush hour Time//////////////////////////////////////////
	   
	   
	//////////////////////////////////Start Closing Time//////////////////////////////////////////
	public void gotohomehour(int whatele, ArrayList ridingOr1, ArrayList ridingOr2, int m, int n){
		
		elevator elevator1 = allEle.get(whatele);
		
		ridingOrMan=ridingOr1;
		ridingOrMan2=ridingOr2;
		homemax=m;
		homemin=n;
		for (int i = 0; i < Man_queue.size(); i++) {
			//input person's floor to each elevator
			Businessman tmpMan = Man_queue.get(i);
			if (whatele == 0 && (tmpMan.getY() >= 270 && tmpMan.getY() <= 540) && tmpMan.getD_y()==570) {
				if (homemax==270 && i == 0) {
					homemax = tmpMan.getY();
				}
				if (homemax > tmpMan.getY()) {
					homemax = tmpMan.getY();
				}
			}
			else if (whatele == 1 && (tmpMan.getY() >= 150 && tmpMan.getY() <= 330) && tmpMan.getD_y()==570) {
				if (homemax==150 && i == 0) {
					homemax = tmpMan.getY();
				}
				if (homemax > tmpMan.getY()) {
					homemax = tmpMan.getY();
				}
			}
			else if (whatele == 2 && (tmpMan.getY() >= 0 && tmpMan.getY() <= 210) && tmpMan.getD_y()==570) {
				if (homemax==0 && i == 0) {
					homemax = tmpMan.getY();
				}
				if (homemax > tmpMan.getY()) {
					homemax = tmpMan.getY();
				}
				//System.out.println(homemax);
			}
			
		}
		
		
		for (int i = 0; i < elevator1.getRidingMan().size(); i++) {
			Businessman tmpMan = elevator1.getRidingMan().get(i);
			if (i == 0)
				homemin = tmpMan.getD_y();
			if (homemin < tmpMan.getD_y()) {
				homemin = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < Man_queue.size(); i++) {
			 //input person's destination to each elevator
			Businessman tmpMan = Man_queue.get(i);
			if (whatele == 0 && (tmpMan.getY() >= 270 && tmpMan.getY() <= 540)) {
				if (tmpMan.getD_y() == 570) {
					if (homemin == 0 && i == 0) {
						homemin = tmpMan.getY();
					}
					if (homemin < tmpMan.getY()) {
						homemin = tmpMan.getY();
					}
				}
			}
			else if (whatele == 1 && (tmpMan.getY() >= 150 && tmpMan.getY() <= 330)) {
				if (tmpMan.getD_y() == 570) {
					if (homemin == 0 && i == 0) {
						homemin = tmpMan.getY();
					}
					if (homemin < tmpMan.getY()) {
						homemin = tmpMan.getY();
					}
				}
			}
			else if (whatele == 2 && (tmpMan.getY() >= 0 && tmpMan.getY() <= 210)) {
				if (tmpMan.getD_y() == 570) {
					if (homemin == 0 && i == 0) {
						homemin = tmpMan.getY();
					}
					if (homemin < tmpMan.getY()) {
						homemin = tmpMan.getY();
					}
				}
			}
		}
		// }
		 //if elevator is going up
		if(elevator1.getUp()){
			elevator1.setD_y(homemax);
		}
		 //if elevator is going down
		if(elevator1.getDown()){//////////////////////////up//////////////////
		
			elevator1.setD_y(homemin);
		
			int currentFloorOfFirstElev = (600-elevator1.getY()) / 30;
			
			if ((600 - elevator1.getY()) % 30 == 0) {//elevator stops.
				ArrayList<Businessman> waitingList = getListAt(currentFloorOfFirstElev);
			
				for(int i=0; i<waitingList.size(); i++){//check boarding people.
					Businessman tmpMan = waitingList.get(i);
					
					if (whatele == 0 && (currentFloorOfFirstElev>=2 && currentFloorOfFirstElev<=11)) {
						
						if ((tmpMan.getD_y()==570) && tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1.getCurrentweight()) <= elevator1.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
					
								tmpMan.setD_x(400 + 35);//whatele==0
			
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
					else if(whatele==1 && currentFloorOfFirstElev>=9 && currentFloorOfFirstElev<=15){
						if ((tmpMan.getD_y()==570)
								&& tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1
										.getCurrentweight()) <= elevator1
										.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
						
							
								tmpMan.setD_x(400 + 85); //whatele==1
						
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
					else if(whatele==2 && currentFloorOfFirstElev >=13 && currentFloorOfFirstElev<=20){
						if ((tmpMan.getD_y() ==570)
								&& tmpMan.getRiding() == false
								&& ((tmpMan.getWeight() + elevator1
										.getCurrentweight()) <= elevator1
										.getLimit())) {
							tmpMan.setRiding(true);
							elevator1.setCurrentweight(tmpMan.getWeight()
									+ elevator1.getCurrentweight());
						
							tmpMan.setD_x(400+135);//whatele==2
									
							elevator1.set_flag(true);
							elevator1.set_open(true);
							waitingList.remove(tmpMan);
							elevator1.getRidingMan().add(tmpMan);
							ridingOrMan.add(tmpMan);
						}
					}
				}
				for(int i=0; i<elevator1.getRidingMan().size(); i++){//check getting out people.
					
					Businessman tmpMan = elevator1.getRidingMan().get(i);
					//System.out.println(tmpMan.getD_y() +" to "+ elevator1.getY());
					if((tmpMan.getD_y()==elevator1.getY()) && tmpMan.getoffriding()==false){
						tmpMan.setoffriding(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator1.getY());
						elevator1.set_open(true);
						elevator1.setFlag2(true);
						allMan.add(tmpMan);
						ridingOrMan2.add(tmpMan);
					}
				}
				Businessman tmpMan2;
				int check=0;
				int check2=0;
				for(int i=0; i<ridingOrMan.size(); i++){
					tmpMan2=ridingOrMan.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 435) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 485) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 535) {
							++check;
							if(tmpMan2.getEndtime()==0){
								tmpMan2.setEndtime(System.currentTimeMillis());
								hf.set_time(hf.get_time()+(tmpMan2.getEndtime()-tmpMan2.getStarttime()));
								hf.setMan_queue(hf.getMan_queue()+1);
							}
							Man_queue.remove(tmpMan2);
							allMan.remove(tmpMan2);
						}
					}
				}
				if(check==ridingOrMan.size()&& check!=0){
					
					elevator1.set_flag(false);
					elevator1.set_open(false);
					ridingOrMan.removeAll(ridingOrMan);
				}
///////////////////////////Until this line is the section people board when elevator go down/////////////////////
	            
  /////////// The section people get out from this line  when elevator go down///////////////
				for(int i=0; i<ridingOrMan2.size(); i++){
					tmpMan2=ridingOrMan2.get(i);
					if (whatele == 0) {
						if (tmpMan2.getX() >= 500) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==1){
						if (tmpMan2.getX() >= 550) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==2){
						if (tmpMan2.getX() >= 600) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
					else if(whatele==3){
						if (tmpMan2.getX() >= 650) {
							++check2;
							elevator1.setCurrentweight(elevator1
									.getCurrentweight() - tmpMan2.getWeight());
							elevator1.getRidingMan().remove(tmpMan2);
						}
					}
				}
				if(check2==ridingOrMan2.size() && check2!=0){
					elevator1.setFlag2(false);
					elevator1.set_open(false);
					ridingOrMan2.removeAll(ridingOrMan2);
				}
				if(elevator1.get_flag() || elevator1.getFlag2()){
					//jp.repaint();
					return;
				}	
			}
		}

		if(elevator1.getY()<=homemax){
			elevator1.setDown(true);
			elevator1.setUp(false);
		}
		else if(elevator1.getY()>=homemin){
			elevator1.setUp(true);
			elevator1.setDown(false);
		}
		if (Man_queue.size() == 0 && elevator1.getRidingMan().size() == 0) {
			elevator1.setUp(true);
			if(whatele==0)
				elevator1.setD_y(270);
			else if(whatele==1)
				elevator1.setD_y(150);
			else if(whatele==2)
				elevator1.setD_y(0);
		}
		if (elevator1.getUp()) {
			if ((elevator1.getY() > elevator1.getD_y())) {
				elevator1.setY(elevator1.getY() - 2);
			}
		}
		if(elevator1.getDown()){
			if(elevator1.getY()<elevator1.getD_y()){
				elevator1.setY(elevator1.getY() + 2);
			}
		}//System.out.println(homemin);
	}
	
	
	public void run(){
		while(true){
			try {
				Thread.sleep(30);//thread speed
				//input people to all floors
				for (int i = 0; i < allMan.size(); i++) {
					Businessman tmpMan = allMan.get(i);
					if (tmpMan.getX() < tmpMan.getD_x()){
						tmpMan.setX(tmpMan.getX() + 4);
					}
					if((tmpMan.getX() >= tmpMan.getD_x()) && (tmpMan.isWait() == false)){
						Man_queue.add(tmpMan);
						if((600-tmpMan.getY())/30==1)
							floor1.add(tmpMan);
						else if((600-tmpMan.getY())/30==2)
							floor2.add(tmpMan);	
						else if((600-tmpMan.getY())/30==3)
							floor3.add(tmpMan);
						else if((600-tmpMan.getY())/30==4)
							floor4.add(tmpMan);	
						else if((600-tmpMan.getY())/30==5)
							floor5.add(tmpMan);
						else if((600-tmpMan.getY())/30==6)
							floor6.add(tmpMan);	
						else if((600-tmpMan.getY())/30==7)
							floor7.add(tmpMan);
						else if((600-tmpMan.getY())/30==8)
							floor8.add(tmpMan);	
						else if((600-tmpMan.getY())/30==9)
							floor9.add(tmpMan);
						else if((600-tmpMan.getY())/30==10)
							floor10.add(tmpMan);
						else if((600-tmpMan.getY())/30==11)
							floor11.add(tmpMan);
						else if((600-tmpMan.getY())/30==12)
							floor12.add(tmpMan);
						else if((600-tmpMan.getY())/30==13)
							floor13.add(tmpMan);	
						else if((600-tmpMan.getY())/30==14)
							floor14.add(tmpMan);
						else if((600-tmpMan.getY())/30==15)
							floor15.add(tmpMan);
						else if((600-tmpMan.getY())/30==16)
							floor16.add(tmpMan);	
						else if((600-tmpMan.getY())/30==17)
							floor17.add(tmpMan);
						else if((600-tmpMan.getY())/30==18)
							floor18.add(tmpMan);
						else if((600-tmpMan.getY())/30==19)
							floor19.add(tmpMan);	
						else if((600-tmpMan.getY())/30==20)
							floor20.add(tmpMan);
						
						tmpMan.setWait(true);
					}
				}
				if (Man_queue.size() != 0) {
					 //manage waiting people
					for (int i = 1; i <= 20; i++) {
						ArrayList<Businessman> waitingList = getListAt(i);
						for (int j = 0; j < waitingList.size(); j++) {
							Businessman tmpMan = waitingList.get(j);
							if (j == 0 && tmpMan.getX() != 400)
								tmpMan.setD_x(400);
							else if (j == 1 && tmpMan.getX() != 370)
								tmpMan.setD_x(370);
							else if (j == 2 && tmpMan.getX() != 340)
								tmpMan.setD_x(340);
							else if (j == 3 && tmpMan.getX() != 310)
								tmpMan.setD_x(310);
							else if (j == 4 && tmpMan.getX() != 280)
								tmpMan.setD_x(280);
							else if (j == 5 && tmpMan.getX() != 250)
								tmpMan.setD_x(250);
							else if (j == 6 && tmpMan.getX() != 220)
								tmpMan.setD_x(220);
							else if (j == 7 && tmpMan.getX() != 190)
								tmpMan.setD_x(190);
							else if (j == 8 && tmpMan.getX() != 160)
								tmpMan.setD_x(160);
							else if (j == 9 && tmpMan.getX() != 130)
								tmpMan.setD_x(130);
							else if (j == 10 && tmpMan.getX() != 100)
								tmpMan.setD_x(100);
							else if (j == 11 && tmpMan.getX() != 70)
								tmpMan.setD_x(70);
							else if (j == 12 && tmpMan.getX() != 40)
								tmpMan.setD_x(40);
							else if (j == 13 && tmpMan.getX() != 10)
								tmpMan.setD_x(10);
						}
					}
				}
				//Select time (Normal or Rushhour or Closing time)
				if(hf.getselecttime()==1){
				//avg_time=0; time=0; Man_queue_human=0;
				regularElevator(0, ridingOrMan11, ridingOrMan12, max1, min1);
				regularElevator(1, ridingOrMan21, ridingOrMan22, max2, min2);
				regularElevator(2, ridingOrMan31, ridingOrMan32, max3, min3);
				regularElevator(3, ridingOrMan41, ridingOrMan42, max4, min4);
				}
				else if(hf.getselecttime()==2){
				//avg_time=0; time=0; Man_queue_human=0;
				officehour(0, workridingOrMan11, workridingOrMan12, workmax1, workmin1);
				officehour(1, workridingOrMan21, workridingOrMan22, workmax2, workmax2);
				officehour(2, workridingOrMan31, workridingOrMan32, workmax3, workmax3);
				regularElevator(3, workridingOrMan41, workridingOrMan42, workmax4, workmax4);
				}
				else if(hf.getselecttime()==3){
			    //avg_time=0; time=0; Man_queue_human=0;
				gotohomehour(0, homeridingOrMan11, homeridingOrMan12, homemax1, homemin1);
				gotohomehour(1, homeridingOrMan21, homeridingOrMan22, homemax2, homemin1);
				gotohomehour(2, homeridingOrMan31, homeridingOrMan32, homemax3, homemin1);
				regularElevator(3, homeridingOrMan41, homeridingOrMan42, homemax4, homemin4);
				}
				//This loop are used when calculate a average time
				for(int i=0; i<Man_queue.size(); i++){
					Businessman tmpMan = Man_queue.get(i);
					if(tmpMan.getStarttime()==0)
						tmpMan.setStarttime(System.currentTimeMillis());
				}
				
				if(hf.getMan_queue()!=0)
					hf.setavg_time((hf.get_time()/1000)/hf.getMan_queue());
				hf.setavgTime(Long.toString(hf.getavg_time()));
				hf.setnumOfWaiting(Integer.toString(Man_queue.size()));
				for(int i = 0; i < allEle.size(); i++){
					elevator tmpele = allEle.get(i);
					if(i==0){
						hf.setboardingPeople1(Integer.toString(tmpele.getRidingMan().size()));
						hf.setelevWeight1(Integer.toString(tmpele.getCurrentweight()));
					}
					else if(i==1){
						hf.setboardingPeople2(Integer.toString(tmpele.getRidingMan().size()));
						hf.setelevWeight2(Integer.toString(tmpele.getCurrentweight()));
					}
					else if(i==2){
						hf.setboardingPeople3(Integer.toString(tmpele.getRidingMan().size()));
						hf.setelevWeight3(Integer.toString(tmpele.getCurrentweight()));
					}
					else if(i==3){
						hf.setboardingPeople4(Integer.toString(tmpele.getRidingMan().size()));
						hf.setelevWeight4(Integer.toString(tmpele.getCurrentweight()));
					}
				}
				jp.repaint();	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println(allEle.get(0).getUp() + " " + (600-allEle.get(0).getD_y())/30 + " " + (600-allEle.get(0).getY())/30);
		}
	}
}
