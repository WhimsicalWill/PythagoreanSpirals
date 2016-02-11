import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	
	private static final long serialVersionUID = 3388639230586152473L;
	private Spirals spirals;
	public int width = 800; 
	public int height = 800;

	
	public DisplayPanel(Spirals spirals) {
		this.spirals = spirals;
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//this method will be used to draw the triangles from the Point array
		for (int i = 0; i < spirals.pointNum - 1; i++) {
			//The three x and y points that will be connected to form a polygon
			int[] arrayX = {spirals.triangles[spirals.pointNum - i - 1].x, spirals.triangles[spirals.pointNum - i - 2].x, spirals.centerX};
			int[] arrayY = {spirals.triangles[spirals.pointNum - i - 1].y, spirals.triangles[spirals.pointNum - i - 2].y, spirals.centerY};
	
			//if 'i' is equal to 0, then this polygon will be drawn with the most recent color
			//Access the colors backwards so that each polygon keeps its color and is not all flashy
			g.setColor(spirals.polygonColors[spirals.pointNum - i]);
			g.fillPolygon(arrayX, arrayY, 3);
		}
	}
}