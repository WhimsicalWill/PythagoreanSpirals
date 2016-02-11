import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.Random; 

public class Spirals extends JFrame {

	private static final long serialVersionUID = 2123820497233056882L;
	private DisplayPanel display;
	public Point[] triangles = new Point[1680];
	public Color[] polygonColors = new Color[1680];
	private double angle = 0;
	private static final int SIDE_LENGTH = 15;
	private static final int PAUSE = 20;
	public int centerX;
	public int centerY;
	private double hypotenuse = SIDE_LENGTH;
	private int triangleNum = 0;
	public int pointNum = 0;
	private Random rand = new Random();
	
	public Spirals() {
		super("Pythagorean Spirals - by Will Knipe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);

		this.display = new DisplayPanel(this);
		centerX = display.width / 2;
		centerY = display.height / 2;
		
		add(display, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void start() {
		while (pointNum < triangles.length) {
				createNewTriangle(triangleNum);
				display.repaint();
				try {
					Thread.sleep(PAUSE);
				} catch (InterruptedException e) { }
				triangleNum++;
		}
	}

	private void setPoint(int x, int y) {
		//given an x and a y, add this point to the array of points
		triangles[pointNum] = new Point(x, y);
		pointNum++;
	}
	
	
	private void createNewTriangle(int num) {
		if (num == 0) 
			setPoint(centerX + SIDE_LENGTH, centerY);
		
		
		angle += Math.atan(SIDE_LENGTH / hypotenuse);
		hypotenuse = Math.sqrt((num + 2) * Math.pow((double) SIDE_LENGTH, 2.0));
		
		int x = (int) (Math.cos(angle) * hypotenuse) + centerX;
		int y = (int) (Math.sin(angle) * hypotenuse) + centerY; 
		
		System.out.println(num + ": " + "x: " + x + " y: " + y + " other: " + centerX);
		setPoint(x, y);
		
		//This creates a new custom color for each polygon, and saves it into an array. 
		float red = (float) rand.nextFloat();
		float green = (float) rand.nextFloat() / 2f;
		float blue = (float) rand.nextFloat() / 2f;
		Color randomColor = new Color(red, green, blue);
		polygonColors[pointNum] = randomColor;
		
	}
	
	// PROGRAM START INSTRUCTIONS
	public static void main(String[] args) {
		Spirals spi = new Spirals();
		spi.start();
	}
}