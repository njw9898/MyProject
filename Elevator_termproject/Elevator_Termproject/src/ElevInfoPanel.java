import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/*
this class is the panel that show extra information about our elevators.
it shows the total weight of boarding people, the number of boarding people, 
average waiting time of all people and the number of waiting people at now.
also this panel has three buttons that changes time. (Rush hour, Normal, Closing)
*/
public class ElevInfoPanel extends JPanel{

	public ElevInfoPanel(){ //set panel size
		setLayout(null);
		setBounds(0, 600, 1000, 100);
	}
	public void paintComponent(Graphics g)
	{
		Font font1 = new Font("Serif",Font.BOLD,15);
		Font font2 = new Font("Serif",Font.TRUETYPE_FONT,14);
		String a = "E l e v a t o r 1";
		String b = "E l e v a t o r 2";
		String c = "E l e v a t o r 3";
		String d = "E l e v a t o r 4";
		String e = "Waiting";
		String f = "People";
		String h = "Average";
		String j = " T i m e";
		
		Color color1 = new Color(255,255,224);
		g.setColor(color1);
		g.fillRect(0, 0, 1000, 100);

		for(int i=0; i<2; i++)  // the section where information (Waiting people, average time)
		{
			g.setColor(Color.red);
			g.drawRect(15+(i*75), 5, 65, 70);
			
			g.setColor(new Color(255,246,143));
			g.fillRect(16+(i*75), 6, 64, 69);
			
			g.setColor(Color.red);
			g.drawLine(15+(i*75), 45, 80+(i*75), 45);
		}
		for(int i=0; i<4; i++){  // the section where information about each elevator(Weight, Num) 
			g.setColor(Color.red);
			g.drawRect(170+(i*120), 5, 105, 70);
			g.setColor(new Color(255,246,143));
			g.fillRect(171+(i*120), 6, 104, 69);
		}
		for(int i=0; i<4; i++){  // the section where information about each elevator(Weight, Num)
			g.setColor(Color.red); 
			g.drawLine(170+(i*120), 25, 275+(i*120), 25);
			g.drawLine(170+(i*120), 45, 275+(i*120), 45);
			g.drawLine(220+(i*120), 25, 220+(i*120), 75);
		}

		g.setFont(font1);           // set font and input string to panel
		g.drawString(e, 25, 20);
		g.drawString(h, 95, 20);
		g.drawString(f, 25, 40);
		g.drawString(j, 95, 40);
		g.drawString(a, 175, 20);
		g.drawString(b, 295, 20);
		g.drawString(c, 415, 20);
		g.drawString(d, 535, 20);

		for(int i=0; i<4; i++)
		{	
			g.setFont(font2);
			g.drawString(" Num", 175+(120*i), 40);
			g.drawString("Weight", 225+(120*i), 40);
		}
		g.setColor(Color.red);
		g.drawRect(670, 5, 310, 70);
		g.setColor(new Color(255,246,143));
		g.fillRect(671, 6, 309, 69);
	}
}
