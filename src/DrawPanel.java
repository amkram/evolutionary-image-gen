import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private static int rand;
	private static Random random = new Random();
	private static ArrayList<CoolPolygon> saved = new ArrayList<CoolPolygon>();
	public static int generation = 0;
	public DrawPanel() {
		setPreferredSize(new Dimension(300,300));
		setSize(new Dimension(300,300));
	}
	public void paintComponent(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		g.setColor(Color.WHITE);
		g.fillRect(0,0,300,300);
				
		if(generation < 3000)
			addPolygon();
		for(int i = 0; i < saved.size(); i++)
		{
			//g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255), 100));
			g.setColor(new Color(0,0,0,100));

		//	g.fillPolygon(saved.get(i));
		//	g.drawString("*", saved.get(i).x, saved.get(i).y);
			g.fillRect(saved.get(i).x, saved.get(i).y, 10, 10);
		}
		
		
		generation++;
		
		
	}
	public void mutate() {
		removePolygon();
		addPolygon();
	}
	public ArrayList<CoolPolygon> getList() {
		return saved;
	}
	public void setList(ArrayList<CoolPolygon> saved) {
		DrawPanel.saved.clear();
		for(CoolPolygon c : saved)
			DrawPanel.saved.add(new CoolPolygon(c)); 
	}
	public static void addPolygon() {
		rand = random.nextInt(5)+3;
		int[] xPoints = new int[rand];
		int[] yPoints = new int[rand];

		for (int i = 0; i < rand; i++) {
			xPoints[i] = random.nextInt(300);
			yPoints[i] = random.nextInt(300);

		}
		int x = random.nextInt(300);
		int y = random.nextInt(300);
		CoolPolygon newPolygon = new CoolPolygon(x, y);
		saved.add(newPolygon);
	
	}
	public static void removePolygon() {
		saved.remove(random.nextInt(saved.size()));
	}
	public BufferedImage getImage(){
		BufferedImage test = new BufferedImage(getWidth()+16, getHeight()+39, BufferedImage.TYPE_INT_ARGB);
		paint(test.getGraphics());
		return test;
 
	}
}
