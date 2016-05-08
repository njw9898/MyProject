
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/* This class manages all of GUI. */

public class MainFrame implements ActionListener {
	private String[] time = new String[3]; //3 times
	private String[] test = new String[3]; //test case for each time (create 97 people per one click
	private String[] passive = new String[3]; // test case for each time(create single person per one click) 
	private JTextArea boardingPeople1 = new JTextArea(); //text areas
	private JTextArea boardingPeople2 = new JTextArea();
	private JTextArea boardingPeople3 = new JTextArea();
	private JTextArea boardingPeople4 = new JTextArea();
	private JTextArea elevWeight1 = new JTextArea();
	private JTextArea elevWeight2 = new JTextArea();
	private JTextArea elevWeight3 = new JTextArea();
	private JTextArea elevWeight4 = new JTextArea();

	private JTextArea numOfWaiting = new JTextArea();//numOfwating. 
	private JTextArea avgTime = new JTextArea();//avgTime.
	private JFrame jf = new JFrame("");
	private Toolkit tk;
	private Image img[] = new Image[3];
	private JPanel buttonPanel = new JPanel();
	private ArrayList<Businessman> allMan = new ArrayList<Businessman>();
	private ArrayList<elevator> elev = new ArrayList<elevator>();

	public int[] floor_count = new int[20];
	int select_time = 1;
	int test_case = 0;
	String waitingnum="";
	String boardingPeoplenum1="";
	String boardingPeoplenum2="";
	String boardingPeoplenum3="";
	String boardingPeoplenum4="";
	
	
	String availableweight1="";
	String availableweight2="";
	String availableweight3="";
	String availableweight4="";
	
	long avg_time=0, Man_queue_human=0, time2=0;
	
	JLabel WeightStateLabel;
	String WeightState = "???";
	inputNumber input;
	
	public void setavg_time(long time){
		this.avg_time=time;
	}
	public long getavg_time(){
		return avg_time;
	}
	public void set_time(long time){
		this.time2=time;
	}
	public long get_time(){
		return time2;
	}
	public void setMan_queue(long time){
		this.Man_queue_human=time;
	}
	public long getMan_queue(){
		return Man_queue_human;
	}
	public void settest_case(int i){
		this.test_case = i;
	}
	public int gettest_case(){
		return test_case;
	}
	public void setnumOfWaiting(String num){
		numOfWaiting.setText("       "+num);
		this.waitingnum = num;
	}
	public String getnumOfWaiting(){
		return waitingnum;
	}
	public void setavgTime(String num){
		avgTime.setText("       "+num);
	}
	public void setboardingPeople1(String num){
		boardingPeople1.setText("      "+num);
		this.boardingPeoplenum1=num;
	}
	public void setboardingPeople2(String num){
		boardingPeople2.setText("      "+num);
		this.boardingPeoplenum2=num;
	}
	public void setboardingPeople3(String num){
		boardingPeople3.setText("      "+num);
		this.boardingPeoplenum3=num;
	}
	public void setboardingPeople4(String num){
		boardingPeople4.setText("   "+num);
		this.boardingPeoplenum4=num;
	}
	public void setelevWeight1(String num){
		elevWeight1.setText("   "+num);
		this.availableweight1=num;
	}
	public void setelevWeight2(String num){
		elevWeight2.setText("   "+num);
		this.availableweight2=num;
	}
	public void setelevWeight3(String num){
		elevWeight3.setText("   "+num);
		this.availableweight3=num;
	}
	public void setelevWeight4(String num){
		elevWeight4.setText("   "+num);
		this.availableweight4=num;
	}
	public String getboardingPeople1(){
		return this.boardingPeoplenum1;
	}
	public String getboardingPeople2(){
		return this.boardingPeoplenum2;
	}
	public String getboardingPeople3(){
		return this.boardingPeoplenum3;
	}
	public String getboardingPeople4(){
		return this.boardingPeoplenum4;
	}
	public String getelevWeight1(){
		return this.availableweight1;
	}
	public String getelevWeight2(){
		return this.availableweight2;
	}
	public String getelevWeight3(){
		return this.availableweight3;
	}
	public String getelevWeight4(){
		return this.availableweight4;
	}
	
	public MainFrame() {
		jf.setLayout(null);
		jf.setBounds(0, 0, 1000 + 20, 600 + 120); //set size of frame and bounds
		// //////////////////////////////////////////////////////
		// 버튼 들
		buttonPanel.setLayout(new GridLayout(20, 1));  
		buttonPanel.setBounds(0, 0, 75, 600);// set size of button panel and bounds

		time[0] = "N o r m a l";
		time[1] = "RushHour";
		time[2] = "Closing";
		test[0] = "T";
		test[1] = "T ";
		test[2] = " T";
		passive[0] = "P";
		passive[1] = "P ";
		passive[2] = " P";
		for (int i = 0; i < 3; i++) { // make buttons that show test case
			JPanel timePanel = new JPanel(new GridLayout(2, 1));
			Font font = new Font("Serif", Font.BOLD, 11);
			JButton tBtn = new JButton(time[i]);

				JButton testBtn = new JButton(test[i]);
				JButton passiveBtn = new JButton(passive[i]);
				JPanel temp = new JPanel(new GridLayout(1, 2));
				tBtn.setBackground(Color.red);
				passiveBtn.addActionListener(this);
				passiveBtn.setBackground(Color.red);
				testBtn.setBackground(Color.red);
				tBtn.addActionListener(this);
				testBtn.addActionListener(this);
				temp.add(testBtn);
				temp.add(passiveBtn);
				timePanel.add(tBtn);
				
				timePanel.add(temp);
				tBtn.setFont(font);
				testBtn.setFont(font);
			timePanel.setBounds(680 + (i * 100), 615, 90, 50);
			jf.add(timePanel);
			
		}

		boardingPeople1.setBounds(175 + (0 * 120), 650, 40, 20); //TextAreas that show the number of boarding people
		boardingPeople2.setBounds(175 + (1 * 120), 650, 40, 20);
		boardingPeople3.setBounds(175 + (2 * 120), 650, 40, 20);
		boardingPeople4.setBounds(175 + (3 * 120), 650, 40, 20);
		boardingPeople1.setEditable(false);
		boardingPeople2.setEditable(false);
		boardingPeople3.setEditable(false);
		boardingPeople4.setEditable(false);
		elevWeight1.setBounds(225 + (0 * 120), 650, 40, 20); //TextAreas that show the total weight of each elevator
		elevWeight2.setBounds(225 + (1 * 120), 650, 40, 20);
		elevWeight3.setBounds(225 + (2 * 120), 650, 40, 20);
		elevWeight4.setBounds(225 + (3 * 120), 650, 40, 20);
		elevWeight1.setEditable(false);
		elevWeight2.setEditable(false);
		elevWeight3.setEditable(false);
		elevWeight4.setEditable(false);
		jf.add(boardingPeople1);
		jf.add(boardingPeople2);
		jf.add(boardingPeople3);
		jf.add(boardingPeople4);
		jf.add(elevWeight1);
		jf.add(elevWeight2);
		jf.add(elevWeight3);
		jf.add(elevWeight4);
		
		
		
		numOfWaiting.setBounds(20, 650, 50, 20);
		numOfWaiting.setEditable(false);
		
		
		avgTime.setBounds(95, 650, 50, 20);
		avgTime.setEditable(false);
		jf.add(numOfWaiting);
		jf.add(avgTime);

		for (int i = 19; i >= 0; i--) { //add button panel at most left side
			JButton btn = new JButton(" " + Integer.toString(i + 1));
			btn.setBackground(new Color(255,255,224));
			btn.addMouseListener(new Mouse(i));
			buttonPanel.add(btn);
		}

		jf.add(buttonPanel);
		// //////////////////////////////////////////////////////

		JPanel jp = new SwingHandler(this, allMan, elev);
		JPanel jp2 = new ElevInfoPanel();
		jf.add(jp);
		jf.add(jp2);

		//new ChatClient(this).start();
		
		for (int i = 0; i < 20; i++) {
			floor_count[i] = 0;
		}

		new AlterationThread(this, allMan, elev, jp).start();
		new ServerInjava(this, elev, allMan, floor_count).start();
		
		//Elevator initialize.
		elevator ele1 = new elevator(0, 570);
		ele1.setX(430);
		ele1.setY(570);
		ele1.set_flag(false);
		ele1.set_open(false);
		ele1.setTTLy(0);
		elev.add(ele1);

		elevator ele2 = new elevator(0, 570);
		ele2.setX(480);
		ele2.setY(570);
		ele2.set_flag(false);
		ele2.set_open(false);
		ele2.setTTLy(180);
		elev.add(ele2);

		elevator ele3 = new elevator(0, 570);
		ele3.setX(530);
		ele3.setY(570);
		ele3.set_flag(false);
		ele3.set_open(false);
		ele3.setTTLy(390);
		elev.add(ele3);

		elevator ele4 = new elevator(0, 570);
		ele4.setX(580);
		ele4.setY(570);
		ele4.set_flag(false);
		ele4.set_open(false);
		ele4.setTTLy(570);
		ele4.setLimit(700);
		elev.add(ele4);
		
		
		
		tk = Toolkit.getDefaultToolkit();// 이걸 이용해서 이미지를 가져올 수 있다.
		img[0] = tk.createImage("퇴근.png");
		img[1] = tk.createImage("아침출근.png");
		img[2] = tk.createImage("평소배경.png");

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Image getImg(int i) {
		return img[i];
	}
//////////////////////////////////////////////////////ActionPerformed
	public void actionPerformed(ActionEvent e) {
		int des_floor;
		int dest;
		int[] destination = new int[97];
		int[] normal_floor = new int[97];
		int[] closing_floor = new int[97];
		int count=0;
		for(int i=0; i<3; i++)
		{ // Show test case
			if(e.getActionCommand().equals(passive[i])){
				if(i==0)
				{
					NormalTest test1 = new NormalTest();
					destination = test1.getRandNormalDestination();
					normal_floor = test1.getRandFloor();
			
					des_floor = destination[0];
					if(floor_count[normal_floor[0]-1]==14){
						floor_count[normal_floor[0]-1]=0;
					}
					Businessman person = new Businessman(
							400 - (floor_count[normal_floor[0]-1] * 30), 600-(des_floor*30), 50);
					person.setY(600-(normal_floor[0]*30));
					person.setDone(true);

					floor_count[normal_floor[0]-1]++;
					allMan.add(person);
				}
				if(i==1)
				{
					RushHourTest test1 = new RushHourTest();
					destination = test1.getRand();
					des_floor = destination[0];
					if(floor_count[0]==14){
						floor_count[0]=0;
					}
					System.out.println(floor_count[0]);
			
					Businessman person = new Businessman(
						400 - (floor_count[0] * 30), 600-(des_floor*30), 50);
						
					person.setY(570);
					person.setDone(true);		
					floor_count[0]++;
					allMan.add(person);
				}
				if(i==2)
				{
					ClosingTest test1 = new ClosingTest();
					closing_floor = test1.getRandFloor();
					des_floor = destination[0];
					if(floor_count[closing_floor[0]-1]==14){
						floor_count[closing_floor[0]-1]=0;
					}
						//System.out.println(des_floor);
					Businessman person = new Businessman(
						400 - (floor_count[closing_floor[0]-1] * 30), 570, 50);
					person.setY(600-(closing_floor[0]*30));
					person.setDone(true);
					
					floor_count[closing_floor[0]-1]++;
					allMan.add(person);
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			//Show average time
			if (e.getActionCommand().equals(time[i])) {
				this.avg_time=0; this.time2=0; this.Man_queue_human=0;
				this.setselecttime(i + 1);
				// System.out.println(select_time);
			}
			if (e.getActionCommand().equals(test[i])) { // test case
				this.avg_time=0; this.time2=0; this.Man_queue_human=0;
				System.out.println(avg_time + " " + time2 + " " + Man_queue_human);
				if(i==1){
					RushHourTest test1 = new RushHourTest();
					//destination = test1.getDestination();
					destination = test1.getRand();
					for(int j=0; j<97; j++){
						des_floor = destination[j];
						if(floor_count[0]==14){
							floor_count[0]=0;
						}
						//System.out.println(des_floor);
						System.out.println(floor_count[0]);
			
						Businessman person = new Businessman(
							400 - (floor_count[0] * 30), 600-(des_floor*30), 50);
						
					person.setY(570);
					person.setDone(true);
						
					floor_count[0]++;
					allMan.add(person);
						
					}
				}
				else if(i==0){
					NormalTest test1 = new NormalTest();
					//destination = test1.getDestination();
					destination = test1.getRandNormalDestination();
					normal_floor = test1.getRandFloor();
					
					for(int j=0; j<97; j++){
						des_floor = destination[j];
						if(floor_count[normal_floor[j]-1]==14){
							floor_count[normal_floor[j]-1]=0;
						}
						Businessman person = new Businessman(
							400 - (floor_count[normal_floor[j]-1] * 30), 600-(des_floor*30), 50);
					person.setY(600-(normal_floor[j]*30));
					person.setDone(true);
					
					floor_count[normal_floor[j]-1]++;
					allMan.add(person);	
					}
				}
				else if(i==2){
					ClosingTest test1 = new ClosingTest();
					closing_floor = test1.getRandFloor();
					for(int j=0; j<97; j++){
						des_floor = destination[j];
						if(floor_count[closing_floor[j]-1]==14){
							floor_count[closing_floor[j]-1]=0;
						}
						//System.out.println(des_floor);
						Businessman person = new Businessman(
							400 - (floor_count[closing_floor[j]-1] * 30), 570, 50);
					person.setY(600-(closing_floor[j]*30));
					person.setDone(true);
					
					floor_count[closing_floor[j]-1]++;
					allMan.add(person);	
					}
				}
			}
		}
	}

	public void setselecttime(int select) {
		this.select_time = select;
	}

	public int getselecttime() {
		return select_time;
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	  //this is the Listener when you click the current floor button 
	   //of course, We don't need to use this Listener, but when I made, I didn't know better code.
	   //so I used this code.
	   public class Mouse implements MouseListener {

	      private int floor;

	      public Mouse() {
	         floor = 0;
	      }

	      
	      public Mouse(int floor) {
	         this.floor = floor;
	      }

	      // When you click the button, then the controller opened .
	      public void mouseClicked(MouseEvent e) {
	         input = new inputNumber(floor);
	      }

	      @Override
	      public void mouseEntered(MouseEvent arg0) {
	         // TODO Auto-generated method stub

	      }

	      @Override
	      public void mouseExited(MouseEvent arg0) {
	         // TODO Auto-generated method stub

	      }

	      @Override
	      public void mousePressed(MouseEvent arg0) {
	         // TODO Auto-generated method stub

	      }

	      @Override
	      public void mouseReleased(MouseEvent arg0) {
	         // TODO Auto-generated method stub

	      }
	   }

	   //this is the controller that you can go to floor.
	   public class inputNumber extends JFrame implements ActionListener {
	      int a; //this is current floor.
	      JLabel DestinationFloor = new JLabel(); // It means the floor that you want to send to.
	      String Destination = ""; // It means just the floor number.

	      public inputNumber(int x) {
	         a = x;
	         
	         //set size.
	         setBounds(950, 0, 370, 600); // located  950, 0 and size is 
	         Container contain = getContentPane();
	         
	         // Main JPaenl in controller.
	         JPanel InputWeightPanel = new JPanel();
	         JPanel CnDPanel = new JPanel();
	         JPanel ButtonPanelN = new JPanel(); // this is the floor 11~20
	         JPanel ButtonPanelS = new JPanel(); // this is the floor 1~10

	         // Elevator Making Label
	         JPanel CnDBorder = new JPanel();
	         CnDBorder.setLayout(null);
	         
	         TitledBorder CnD = new TitledBorder(new LineBorder(Color.ORANGE),
	               "ELEVATOR FLOOR"); //just symbolic name.
	         CnD.setTitleColor(Color.red);
	         CnDBorder.setBorder(CnD);
	         CnDBorder.setBounds(185, 210, 155, 240);

	         JPanel CurrentPanel = new JPanel(); // there is place the mark current floor.
	         CurrentPanel.setLayout(null);
	         CurrentPanel.setBorder(new TitledBorder(new LineBorder(
	               (Color.magenta)), "CURRENT"));
	         CurrentPanel.setBounds(15, 15, 125, 100);

	         JPanel DestinationPanel = new JPanel(); // there is place the mark destination floor.
	         DestinationPanel.setLayout(null);
	         DestinationPanel.setBorder(new TitledBorder(new LineBorder(
	               (Color.magenta)), "DESTINATION"));
	         DestinationPanel.setBounds(15, 130, 125, 100);

	         CnDBorder.add(CurrentPanel);
	         CnDBorder.add(DestinationPanel);

	         JLabel CurrentFloor = new JLabel(); //this is the mark current floor
	         CurrentFloor.setText("" + (a + 1));
	         CurrentFloor.setHorizontalAlignment(JLabel.CENTER);
	         CurrentFloor.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
	         CurrentFloor.setBounds(11, 8, 100, 100);
	         
	         DestinationFloor.setText(Destination);  
	         DestinationFloor.setHorizontalAlignment(JLabel.CENTER);
	         DestinationFloor.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
	         DestinationFloor.setBounds(11, 8, 100, 100);

	         CurrentPanel.add(CurrentFloor);
	         DestinationPanel.add(DestinationFloor);

	         // EnterButton if you enter this, then your all inputing is completed
	         JPanel EnterPanel = new JPanel();
	         EnterPanel.setLayout(null);
	         EnterPanel.setBorder(new LineBorder(Color.green, 2));
	         EnterPanel.setBounds(230, 490, 110, 50);
	         JButton EnterButton = new JButton("ENTER");
	         EnterButton.addActionListener(this);
	         EnterButton.setBounds(10, 10, 90, 30);
	         ;
	         EnterPanel.add(EnterButton);

	         // button in Elevator
	         JButton[] DestinationButton = new JButton[20];
	         InputWeightPanel.setLayout(new BorderLayout());
	         ButtonPanelN.setBounds(15, 20, 120, 150);
	         ButtonPanelS.setBounds(15, 171, 120, 150);
	         ButtonPanelN.setLayout(new GridLayout(5, 2));
	         ButtonPanelS.setLayout(new GridLayout(5, 2));

	         // Elevator Button border
	         JPanel ElevatorButton = new JPanel();
	         ElevatorButton.setLayout(null);
	         TitledBorder ElevatorBorder = new TitledBorder(new LineBorder(
	               Color.RED), "ELEVATOR BUTTON");
	         ElevatorBorder.setTitleColor(Color.red);
	         ElevatorButton.setBorder(ElevatorBorder);
	         ElevatorButton.setBounds(20, 210, 150, 330);

	         //this is making Elevator Button. when you inputing, then the value write the destination label.
	         for (int i = 9; i >= 5; i--) {
	            DestinationButton[i] = new JButton("" + (i + 1));
	            DestinationButton[i].setSize(30, 20);
	            if (i == a)
	               DestinationButton[i].setBackground(Color.red);
	            else
	               DestinationButton[i].addActionListener(this);
	            ButtonPanelN.add(DestinationButton[i]);

	            DestinationButton[i + 10] = new JButton("" + ((i + 1) + 10));
	            DestinationButton[i + 10].setSize(30, 20);
	            if ((i + 10) == a)
	               DestinationButton[i + 10].setBackground(Color.red);
	            else
	               DestinationButton[i + 10].addActionListener(this);
	            ButtonPanelN.add(DestinationButton[i + 10]);
	         }
	         for (int i = 4; i >= 0; i--) {
	            DestinationButton[i] = new JButton("" + (i + 1));
	            DestinationButton[i].setSize(30, 20);

	            if (i == a)
	               DestinationButton[i].setBackground(Color.red);
	            else if (select_time == 2 && (i == 1 || i == 2)
	                  && (a == 0 || a == 1 || a == 2)) {
	               DestinationButton[i].setBackground(Color.red);
	            } else
	               DestinationButton[i].addActionListener(this);
	            ButtonPanelS.add(DestinationButton[i]);

	            DestinationButton[i + 10] = new JButton("" + ((i + 1) + 10));
	            DestinationButton[i + 10].setSize(30, 20);
	            if ((i + 10) == a)
	               DestinationButton[i + 10].setBackground(Color.red);
	            else
	               DestinationButton[i + 10].addActionListener(this);
	            ButtonPanelS.add(DestinationButton[i + 10]);
	         }
	         ElevatorButton.add(ButtonPanelN);
	         ElevatorButton.add(ButtonPanelS);

	         // Weight State Panel
	         JPanel WeightStatePanel = new JPanel();
	         WeightStatePanel.setLayout(null);
	         TitledBorder WeightState = new TitledBorder(new LineBorder(
	               Color.CYAN, 2), "WEIGHT STATE");
	         WeightState.setTitleColor(Color.red);
	         WeightStatePanel.setBorder(WeightState);
	         WeightStatePanel.setBounds(15, 45, 155, 120);

	         // Weight State/
	         WeightStateLabel = new JLabel();
	         WeightStateLabel.setText("???");
	         WeightStateLabel.setFont(new Font("궁서", Font.BOLD, 20));
	         WeightStateLabel.setHorizontalAlignment(JLabel.CENTER);

	         WeightStateLabel.setBounds(27, 50, 100, 20);
	         WeightStatePanel.add(WeightStateLabel);

	         // Weight Button Panel
	         JPanel WeightPanel = new JPanel();
	         WeightPanel.setLayout(null);
	         TitledBorder WeightMark = new TitledBorder(new LineBorder(
	               Color.BLUE), "WEIGHT BUTTON");
	         WeightMark.setTitleColor(Color.red);
	         WeightPanel.setBorder(WeightMark);
	         WeightPanel.setBounds(185, 45, 155, 150);

	         //this is  Weight Button
	         InputWeightPanel.setLayout(new GridLayout(3, 3));
	         InputWeightPanel.setBounds(16, 20, 124, 90); // button size 41
	         JButton[] WeightButton = new JButton[11];

	         WeightButton[0] = new JButton("" + 0);
	         WeightButton[0].addActionListener(new WeightAction());
	         WeightButton[0].setBounds(16, 110, 41, 30);

	         for (int i = 1; i <= 9; i++) {
	            WeightButton[i] = new JButton("" + i);
	            WeightButton[i].addActionListener(new WeightAction());
	            InputWeightPanel.add(WeightButton[i]);
	         }
	         WeightButton[10] = new JButton("Reset");
	         WeightButton[10].addActionListener(new WeightAction());
	         WeightButton[10].setBounds(57, 110, 82, 30);

	         WeightPanel.add(InputWeightPanel);
	         WeightPanel.add(WeightButton[0]);
	         WeightPanel.add(WeightButton[10]);

	         // Containg all JPanel
	         contain.add(CnDBorder);
	         contain.add(WeightPanel);
	         contain.add(WeightStatePanel);
	         contain.add(ElevatorButton);
	         contain.add(EnterPanel);
	         //this is not used, but I use this.
	         contain.add(CnDPanel);

	         repaint();
	         setVisible(true);
	      }

	      public void actionPerformed(ActionEvent e) {
	         // when input elevator button, then go to
	         for (int j = 1; j <= 20; j++) {
	            if (e.getActionCommand().equalsIgnoreCase("" + (j))) {
	               Destination = "" + (j);
	               DestinationFloor.setText(Destination);

	            }
	         }
	         //when you input the button "enter", then you all inputing is completed
	         if (e.getActionCommand().equalsIgnoreCase("Enter")) {
	            int weight;
	            int dest = Integer.parseInt(Destination);
	            int des_floor = 600 - ((dest) * 30);
	            
	            //when you don't control weight, then default value is 50.
	            if (WeightState.equals("???")) {
	               weight = 50;
	            } else
	               weight = Integer.parseInt(WeightState);

	            if (floor_count[a] == 14) { // if the people in floor are 14, then 0
	               floor_count[a] = 0;
	            }
	            System.out.println(floor_count[dest - 1]);
	            
	            //and make man in current floor that want to go to destination.
	            Businessman person = new Businessman(
	                  400 - (floor_count[a] * 30), des_floor, weight);
	            person.setY(600/* 총 높이 */- (a + 1) * 30);
	            person.setPri(0);
	            person.setDone(true);
	            // System.out.println(j + "가 눌림");
	            floor_count[a]++;
	            allMan.add(person);
	            setVisible(false);
	            WeightState = "???";
	            return;
	         }
	      }
	   }



	   public class WeightAction implements ActionListener {

	      public WeightAction() {

	      }

	      // when you input weight button. 
	      public void actionPerformed(ActionEvent e) {
	         for (int i = 0; i <= 9; i++)
	            if (e.getActionCommand().equals("" + i)) {
	               if (WeightState.equals("???")) { // if inputing weight button first
	                  if (i == 0)
	                     return;
	                  WeightState = "";
	               }else if (WeightState.length() >= 2) { // if you want weight length 3.
	                  if (WeightState.length() == 2
	                        && WeightState.charAt(0) == '1') { // we make this code when you want length 3 then first value is must '1'
	                     WeightState = WeightState + "" + i;
	                     WeightStateLabel.setText(WeightState);
	                  }
	                  return;
	               }
	               WeightState = WeightState + "" + i;
	               WeightStateLabel.setText(WeightState);
	               return;
	            }
	         if (e.getActionCommand().equals("Reset")) {
	            WeightState = "???";
	            WeightStateLabel.setText(WeightState);
	         }
	      }
	   }
	}