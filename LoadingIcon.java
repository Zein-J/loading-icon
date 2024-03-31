//Loading Icon - Zein Al-Jaradat
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import net.miginfocom.swing.MigLayout;

public class LoadingIcon implements ActionListener {

	public static void main(String[] args) {
		new LoadingIcon();
	}

	DrawingPanel dPanel;
	JPanel panel;
	JFrame win;
	static int panW = 800;
	static int panH = 800;

	//					  (point 1 ,point 2)
	//					   (x1 ,y1 ,x2 ,y2)
	Line lineTop = new Line(220,200,580,200);
	Line lineBot = new Line(220,600,580,600);
	
	//							(x	, y  , w  , l  );
	Square compCube = new Square(300, 0, 200, 200);
	Square compCube2 = new Square(300, 0, 200, 200);
	
	Timer timer = new Timer(20, this);

	LoadingIcon(){
		//Set up window
		win = new JFrame("Loading Icon");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set Cube locations using move variable:
		/* Much easier than changing the original variable*/
		compCube.moveY = 400;
		compCube2.moveY = 0;
		
		dPanel = new DrawingPanel();
		dPanel.setPreferredSize(new Dimension (panW, panH));
		
		setupGUI();
		
		win.add(panel);
		win.pack();
		win.setLocationRelativeTo(null);
		win.setVisible(true);

		timer.start();
	}

	class Line {
		double x1,y1,x2,y2;
		double cx,cy;
		
		Line(double a, double b, double c, double d) {
			x1=a; y1=b; x2=c; y2= d;
			cx = (x1+x2)/2.0;	//Center of x
			cy = (y1+y2)/2.0;   //Center of y
		}
		
		void draw(Graphics2D g2) {
			g2.drawLine( (int)x1, (int)y1, (int)x2,  (int)y2);
		}
	}
	
	JButton btn1;
	
	void setupGUI() {
		
		panel = new JPanel(new MigLayout("wrap 2, insets 20"));
		panel.setPreferredSize(new Dimension (panW+50, panH+50));
		panel.add(dPanel, "span 2");
		
		panel.setBackground(new Color(000, 000, 000));
		
		btn1 = new JButton("Pause");
		btn1.addActionListener(new BtnAL());
		panel.add(btn1, "growx, wrap");
		
		
	}

	//inner class
	class DrawingPanel extends JPanel{

		DrawingPanel(){
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(panW, panH));
		}

		@Override
		public void paintComponent(Graphics g) {			
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2.setStroke(new BasicStroke(3));
			g2.setColor(new Color(255,154,0));
			g2.drawOval(200,195,400,20);
			g2.setColor(new Color(39,167,216));
			g2.drawOval(200,585,400,20);
			
			compCube.draw(g2);
			compCube2.draw(g2);
			
			g2.setColor(new Color(0, 0, 0));
			g2.fillRect(0, 0, 800, 200);
			g2.fillRect(0, 600, 800, 200);
			g2.fillRect(0, 0, 200, 800);
			g2.fillRect(600, 0, 200, 800);
			
			g2.setStroke(new BasicStroke(3));
			g2.setColor(new Color(255,154,0));
			lineTop.draw(g2);
			g2.setColor(new Color(39,167,216));
			lineBot.draw(g2);
		}		
	}
	
	public class BtnAL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Pause")) {
				timer.stop();
				btn1.setText("UnPause");
			}
			if (e.getActionCommand().equals("UnPause")) {
				timer.start();
				btn1.setText("Pause");
			}
		}
	}

	//event listener for timer (main class)
	@Override
	public void actionPerformed(ActionEvent e) {
		compCube.move();
		compCube2.move();
		dPanel.repaint();
		win.setTitle("1:  " + compCube.moveY + "    2:  " + compCube2.moveY);
	}
}
