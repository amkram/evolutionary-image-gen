import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BestFrame extends JFrame {
	private BufferedImage img;
	
	public BestFrame()
	{
		JPanel j = new JPanel() {
			public void paintComponent(Graphics g){
				g.clearRect(0,0,300,300);
				if(img != null)
					g.drawImage(img, 0, 0, null);
			}
		};
		add(j);
		
	}
	public void setImg(BufferedImage img)
	{
		this.img = img;
	}
}
