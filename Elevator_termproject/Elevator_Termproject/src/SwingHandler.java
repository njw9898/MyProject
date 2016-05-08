
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SwingHandler extends JPanel
{
	/* this class is all paintings except for bottom of our gui*/
	private ArrayList<Businessman> allMan;
	private ArrayList<elevator> elev;
	private int cnt = 0;
	private int cnt2=0;
	private int cnt3=0;
	private int cnt4=0;
	private int cnt5=0;
	
	MainFrame jf;
	
	public SwingHandler(MainFrame jf, ArrayList<Businessman> allMan, ArrayList<elevator> elev){
		setLayout(null);
		setBounds(75, 0, 925, 600);
		this.allMan = allMan;
		this.elev = elev;
		this.jf = jf;
	}
	
	public void paintComponent(Graphics g){
		
		if (jf.getselecttime() == 3) {
			///////Normal time painting///////
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.drawImage(jf.getImg(0), 0, 0, this.getWidth(), this.getHeight(),
					this);

			g.drawLine(0, 30, 430, 30);
			for (int i = 0; i < 20; i++) { // lines for dividing floors (Entrance)
				if (i == 0)
					continue;
				g.setColor(Color.WHITE);
				g.drawLine(0, i * 30, 430, i * 30);
			}
			for (int i = 0; i < 5; i++) { // lines for dividing elevators
				g.setColor(Color.WHITE);
				g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
			}
			for (int i = 0; i < 20; i++) { // lines for dividing floors (Exit)
				if (i == 0)
					continue;
				g.setColor(Color.WHITE);
				g.drawLine(630, i * 30, 925, i * 30);
			}
			
			//draw opening and closing elevator
			elevator ele1 = elev.get(0);
			if (!ele1.get_open()) { 
				g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30,
						this);
				cnt2 = 0;
			} else if (ele1.get_open()) {
				g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30,
						this);
				if (cnt2 / 10 == 1)
					g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50,
							30, this);
				cnt2++;
				// System.out.println(cnt2);
			}

			elevator ele2 = elev.get(1);

			if (!ele2.get_open()) {
				g.drawImage(ele2.getImg(0), ele2.getX(), ele2.getY(), 50, 30,
						this);
				cnt3 = 0;
			} else if (ele2.get_open()) {
				g.drawImage(ele2.getImg(1), ele2.getX(), ele2.getY(), 50, 30,
						this);
				if (cnt3 / 10 == 1)
					g.drawImage(ele2.getImg(2), ele2.getX(), ele2.getY(), 50,
							30, this);
				cnt3++;
				// System.out.println(cnt2);
			}
			elevator ele3 = elev.get(2);
			if (!ele3.get_open()) {
				g.drawImage(ele3.getImg(0), ele3.getX(), ele3.getY(), 50, 30,
						this);
				cnt4 = 0;
			} else if (ele3.get_open()) {
				g.drawImage(ele3.getImg(1), ele3.getX(), ele3.getY(), 50, 30,
						this);
				if (cnt4 / 10 == 1)
					g.drawImage(ele3.getImg(2), ele3.getX(), ele3.getY(), 50,
							30, this);
				cnt4++;
				// System.out.println(cnt2);
			}
			elevator ele4 = elev.get(3);
			if (!ele4.get_open()) {
				g.drawImage(ele4.getImg(0), ele4.getX(), ele4.getY(), 50, 30,
						this);
				cnt5 = 0;
			} else if (ele4.get_open()) {
				g.drawImage(ele4.getImg(1), ele4.getX(), ele4.getY(), 50, 30,
						this);
				if (cnt5 / 10 == 1)
					g.drawImage(ele4.getImg(2), ele4.getX(), ele4.getY(), 50,
							30, this);
				cnt5++;
			}
			
			//draw moving people
			for (int i = 0; i < allMan.size(); i++) {
				Businessman tmpMan = allMan.get(i);
				if (tmpMan.getX() >= tmpMan.getD_x())
					g.drawImage(tmpMan.getImg(0), tmpMan.getX(), tmpMan.getY(),
							30, 30, this);
				else {
					if (cnt % 2 == 0)
						g.drawImage(tmpMan.getImg(0), tmpMan.getX(),
								tmpMan.getY(), 30, 30, this);
					else if(cnt % 3 ==0)
						g.drawImage(tmpMan.getImg(1), tmpMan.getX(),
								tmpMan.getY(), 30, 30, this);
					else
						g.drawImage(tmpMan.getImg(2), tmpMan.getX(),
								tmpMan.getY(), 30, 30, this);
				
				}
			}
			cnt++;
		}
		///Rush hour time painting
		else if(jf.getselecttime()==2){
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.drawImage(jf.getImg(1), 0, 0, this.getWidth(), this.getHeight(),
						this);
				// g.fillRect(0, 0, 430, 30);
				g.setColor(Color.YELLOW);
				g.drawLine(0, 30, 430, 30);
				for (int i = 0; i < 20; i++) { //draw line for dividing floors(Entrance)
					if (i == 0)
						continue;
					g.setColor(Color.WHITE);
					g.drawLine(0, i * 30, 430, i * 30);
				}
				for (int i = 0; i < 5; i++) { //draw line for dividing elevators
					g.setColor(Color.WHITE);
					g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
				}
				for (int i = 0; i < 20; i++) { //draw line for dividing floors(Exit)
					if (i == 0)
						continue;
					g.setColor(Color.WHITE);
					g.drawLine(630, i * 30, 925, i * 30);
				}
				
				
				//draw opening and closing elevators
				elevator ele1 = elev.get(0);
				if (!ele1.get_open()) {
					g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30,
							this);
					cnt2 = 0;
				} else if (ele1.get_open()) {
					g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30,
							this);
					if (cnt2 / 10 == 1)
						g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50,
								30, this);
					cnt2++;
					// System.out.println(cnt2);
				}

				elevator ele2 = elev.get(1);

				if (!ele2.get_open()) {
					g.drawImage(ele2.getImg(0), ele2.getX(), ele2.getY(), 50, 30,
							this);
					cnt3 = 0;
				} else if (ele2.get_open()) {
					g.drawImage(ele2.getImg(1), ele2.getX(), ele2.getY(), 50, 30,
							this);
					if (cnt3 / 10 == 1)
						g.drawImage(ele2.getImg(2), ele2.getX(), ele2.getY(), 50,
								30, this);
					cnt3++;
					// System.out.println(cnt2);
				}
				elevator ele3 = elev.get(2);
				if (!ele3.get_open()) {
					g.drawImage(ele3.getImg(0), ele3.getX(), ele3.getY(), 50, 30,
							this);
					cnt4 = 0;
				} else if (ele3.get_open()) {
					g.drawImage(ele3.getImg(1), ele3.getX(), ele3.getY(), 50, 30,
							this);
					if (cnt4 / 10 == 1)
						g.drawImage(ele3.getImg(2), ele3.getX(), ele3.getY(), 50,
								30, this);
					cnt4++;
					// System.out.println(cnt2);
				}
				elevator ele4 = elev.get(3);
				if (!ele4.get_open()) {
					g.drawImage(ele4.getImg(0), ele4.getX(), ele4.getY(), 50, 30,
							this);
					cnt5 = 0;
				} else if (ele4.get_open()) {
					g.drawImage(ele4.getImg(1), ele4.getX(), ele4.getY(), 50, 30,
							this);
					if (cnt5 / 10 == 1)
						g.drawImage(ele4.getImg(2), ele4.getX(), ele4.getY(), 50,
								30, this);
					cnt5++;
				}
				for (int i = 0; i < allMan.size(); i++) {
					Businessman tmpMan = allMan.get(i);
					if (tmpMan.getX() >= tmpMan.getD_x())
						g.drawImage(tmpMan.getImg2(2), tmpMan.getX(), tmpMan.getY(),
								30, 30, this);
					else {
						if (cnt % 2 == 0)
							g.drawImage(tmpMan.getImg2(0), tmpMan.getX(),
									tmpMan.getY(), 30, 30, this);
						else if(cnt % 3 ==0)
							g.drawImage(tmpMan.getImg2(1), tmpMan.getX(),
									tmpMan.getY(), 30, 30, this);
						else
							g.drawImage(tmpMan.getImg2(2), tmpMan.getX(),
									tmpMan.getY(), 30, 30, this);

					}
				}
				cnt++;
		}
		//Closing time
		else if(jf.getselecttime()==1){
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.drawImage(jf.getImg(2), 0, 0, this.getWidth(), this.getHeight(),
					this);
			// g.fillRect(0, 0, 430, 30);
			g.setColor(Color.YELLOW);
			g.drawLine(0, 30, 430, 30);
			for (int i = 0; i < 20; i++) { //draw lines for dividing floors(Entrance)
				if (i == 0)
					continue;
				g.setColor(Color.WHITE);
				g.drawLine(0, i * 30, 430, i * 30);
			}
			for (int i = 0; i < 5; i++) { //draw line for dividing elevators
				g.setColor(Color.WHITE);
				g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
			}
			for (int i = 0; i < 20; i++) { //draw lines for dividing floors(Exit)
				if (i == 0)
					continue;
				g.setColor(Color.WHITE);
				g.drawLine(630, i * 30, 925, i * 30);
			}
			
			//draw opening and closing elevators
			elevator ele1 = elev.get(0);
			if (!ele1.get_open()) {
				g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30,
						this);
				cnt2 = 0;
			} else if (ele1.get_open()) {
				g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30,
						this);
				if (cnt2 / 10 == 1)
					g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50,
							30, this);
				cnt2++;
				// System.out.println(cnt2);
			}

			elevator ele2 = elev.get(1);

			if (!ele2.get_open()) {
				g.drawImage(ele2.getImg(0), ele2.getX(), ele2.getY(), 50, 30,
						this);
				cnt3 = 0;
			} else if (ele2.get_open()) {
				g.drawImage(ele2.getImg(1), ele2.getX(), ele2.getY(), 50, 30,
						this);
				if (cnt3 / 10 == 1)
					g.drawImage(ele2.getImg(2), ele2.getX(), ele2.getY(), 50,
							30, this);
				cnt3++;
				// System.out.println(cnt2);
			}
			elevator ele3 = elev.get(2);
			if (!ele3.get_open()) {
				g.drawImage(ele3.getImg(0), ele3.getX(), ele3.getY(), 50, 30,
						this);
				cnt4 = 0;
			} else if (ele3.get_open()) {
				g.drawImage(ele3.getImg(1), ele3.getX(), ele3.getY(), 50, 30,
						this);
				if (cnt4 / 10 == 1)
					g.drawImage(ele3.getImg(2), ele3.getX(), ele3.getY(), 50,
							30, this);
				cnt4++;
				// System.out.println(cnt2);
			}
			elevator ele4 = elev.get(3);
			if (!ele4.get_open()) {
				g.drawImage(ele4.getImg(0), ele4.getX(), ele4.getY(), 50, 30,
						this);
				cnt5 = 0;
			} else if (ele4.get_open()) {
				g.drawImage(ele4.getImg(1), ele4.getX(), ele4.getY(), 50, 30,
						this);
				if (cnt5 / 10 == 1)
					g.drawImage(ele4.getImg(2), ele4.getX(), ele4.getY(), 50,
							30, this);
				cnt5++;
			}
			
			//draw moving people
			for (int i = 0; i < allMan.size(); i++) {
				Businessman tmpMan = allMan.get(i);
				if (tmpMan.getX() >= tmpMan.getD_x())
					g.drawImage(tmpMan.getImg3(1), tmpMan.getX(), tmpMan.getY(),
							30, 30, this);
				else {
					if (cnt % 2 == 0)
						g.drawImage(tmpMan.getImg3(0), tmpMan.getX(),
								tmpMan.getY(), 30, 30, this);
					else if(cnt % 3 == 0)
						g.drawImage(tmpMan.getImg3(1), tmpMan.getX(),
								tmpMan.getY(), 30, 30, this);
					else
						g.drawImage(tmpMan.getImg3(2), tmpMan.getX(),
								tmpMan.getY(), 30, 30, this);
				}
			}
			cnt++;
		}
		}
}

