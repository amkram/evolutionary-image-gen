import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;


public class CoolPolygon /*extends Polygon*/ {
	private Color c;
	private Random random = new Random();
	private int ALPHA = 20;
	public int x=0,y=0;
	
	public CoolPolygon(int x, int y){
		this.x = x;
		this.y = y;
	}
//	public CoolPolygon(int[] x, int[] y, int np) {
//		super(x, y, np);
//		
//	}
//	
	public CoolPolygon(CoolPolygon c) {
//		super(c.xpoints, c.ypoints, c.npoints);
		this.x = c.x;
		this.y = c.y;
	}
//
//	public Color getColor() {
//		return c;
//	}
//	

	public void mutate() {
		
		
			DrawPanel.removePolygon();
			DrawPanel.addPolygon();

		
		

	}

//	public int getAlpha() {
//		return ALPHA;
//	}
	//public String toString() {
//		return this.xpoints[0] + " " + ypoints[0];
//	}

}
