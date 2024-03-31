//Square - Zein Al-Jaradat
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

class Square {

	double angle = 0.0;
	double moveX = 0.0;		//moving in the x direction
	double moveY = 0.0;	//moving in the y direction

	final double x1, y1, x2, y2;
	final double cx,cy;

	Square (double posx, double posy, double wx, double ly) {
		x1 = posx; y1 = posy; x2 = wx; y2 = ly;

		cx = ((x2/2) + x1);		//Center of x
		cy = ((y2/2) + y1);		//Center of y
	}

	void draw(Graphics2D g2) {
		g2.rotate(angle, cx + moveX, cy + moveY);

		g2.setColor(new Color(255,255,255));
		g2.fillRect( (int)(x1 + moveX), (int)(y1 + moveY), (int)x2,  (int)y2);

		details(x1 + moveX, y1 + moveY, g2);

		if ((y1+moveY) > LoadingIcon.panH-200) {
			g2.setColor(new Color(255,255,255));
			g2.fillRect( (int)(x1 + moveX), (int)(y1 + moveY - LoadingIcon.panH), (int)x2,  (int)y2);

			details(x1 + moveX, y1 + moveY - LoadingIcon.panH, g2);
		}

		g2.rotate(-angle, cx + moveX, cy + moveY);
	}

	void move () {
		angle += 0.01;

		//moveX += 0.0;
		moveY += 10.0;

		if ((y1+moveY) > LoadingIcon.panH) {
			moveY = 0;
		}
	}

	void details (double x, double y, Graphics g) {
		g.setColor(Color.BLACK);
		
		//top
		Polygon edgeCut = new Polygon();
		edgeCut.addPoint((int)x+50, (int)y-1);
		edgeCut.addPoint((int)x+75, (int)y+20);
		edgeCut.addPoint((int)x+125, (int)y+20);
		edgeCut.addPoint((int)x+150, (int)y-1);
		g.fillPolygon(edgeCut);
		
		//bottom
		edgeCut = new Polygon();
		edgeCut.addPoint((int)x+50, (int)y+201);
		edgeCut.addPoint((int)x+75, (int)y+180);
		edgeCut.addPoint((int)x+125, (int)y+180);
		edgeCut.addPoint((int)x+150, (int)y+201);
		g.fillPolygon(edgeCut);
		
		//right
		edgeCut = new Polygon();
		edgeCut.addPoint((int)x+201, (int)y+50);
		edgeCut.addPoint((int)x+180, (int)y+75);
		edgeCut.addPoint((int)x+180, (int)y+125);
		edgeCut.addPoint((int)x+201, (int)y+150);
		g.fillPolygon(edgeCut);
		
		//left
		edgeCut = new Polygon();
		edgeCut.addPoint((int)x-1,	(int)y+50);
		edgeCut.addPoint((int)x+20, (int)y+75);
		edgeCut.addPoint((int)x+20, (int)y+125);
		edgeCut.addPoint((int)x-1,	(int)y+150);
		g.fillPolygon(edgeCut);

		g.setColor(new Color(127, 131, 132)); //Gray
		g.fillOval((int)x+35, (int)y+35, 130, 130);

		//top two lines
		g.fillRect((int)x+75, (int)y+20, 5, 25);
		g.fillRect((int)x+120, (int)y+20, 5, 25);

		//bottom two lines
		g.fillRect((int)x+75, (int)y+155, 5, 25);
		g.fillRect((int)x+120, (int)y+155, 5, 25);

		//right two lines
		g.fillRect((int)x+155, (int)y+75, 25, 5);
		g.fillRect((int)x+155, (int)y+120, 25, 5);

		//left two lines
		g.fillRect((int)x+20, (int)y+75, 25, 5);
		g.fillRect((int)x+20, (int)y+120, 25, 5);
		
		g.setColor(Color.WHITE);
		
		//middle circle
		g.fillOval((int)x+62, (int)y+62, 76, 76);
		
		//white extensions
		g.fillRect((int)x+80, (int)y+16, 40, 5); //top
		g.fillRect((int)x+80, (int)y+179, 40, 5); //bottom
		g.fillRect((int)x+16, (int)y+80, 5, 40); //left
		g.fillRect((int)x+179, (int)y+80, 5, 40); //right
		
		g.setColor(new Color(240, 149, 172)); //Pink
		
		//pink lines
		g.fillRect((int)x+97, (int)y+35, 6, 27); //top
		g.fillRect((int)x+97, (int)y+138, 6, 27); //bottom
		g.fillRect((int)x+35, (int)y+97, 27, 6); //left
		g.fillRect((int)x+138, (int)y+97, 27, 6); //right
		
		//heart
		g.fillOval((int)x+72, (int)y+78, 28, 28);
		g.fillOval((int)x+100, (int)y+78, 28, 28);
		g.fillRect((int)x+80, (int)y+92, 40, 13);
		
		Polygon triangle = new Polygon();
		triangle.addPoint((int)x+73, (int)y+98);
		triangle.addPoint((int)x+127, (int)y+98);
		triangle.addPoint((int)x+100, (int)y+125);
		g.fillPolygon(triangle);


	}

}
