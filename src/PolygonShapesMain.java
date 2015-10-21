import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class PolygonShapesMain extends JFrame {
		
		
		private DrawPanel panel;
		private Random random;
	
		private double currFitness;
		private int generation = 0;
		public PolygonShapesMain()
		{	
			setDefaultCloseOperation(EXIT_ON_CLOSE);	
			setSize(300,300);
			panel = new DrawPanel();
			Container contentPane = getContentPane();
			contentPane.setLayout(new BorderLayout());
			contentPane.add( panel, BorderLayout.CENTER );

			setVisible(true);
			
			random = new Random();
			newGeneration();
			ArrayList<CoolPolygon> fittestGeneration = new ArrayList<CoolPolygon>();
			ArrayList<CoolPolygon> fittestCopy = new ArrayList<CoolPolygon>();
			ArrayList<CoolPolygon> shapes = null;
			
			BestFrame bestF = new BestFrame();
			bestF.setSize(300,300);
			bestF.setVisible(true);
			while(true)
			{
				
				if(generation == 3000)
				{
					shapes = panel.getList();
					for(CoolPolygon c : shapes)
						fittestGeneration.add(c);
					currFitness = getFitness();
				}
				else if (generation > 3000){
					
				panel.mutate();
				double getFit = getFitness();
				if(getFit < currFitness){
					System.out.println("New DNA");
					System.out.println(getFit);
					fittestGeneration.clear();
		    		for(CoolPolygon c : panel.getList())
		    		{
		    			fittestGeneration.add(c);
		    		}
		    		currFitness = getFit;
		    		bestF.setImg(panel.getImage());
		    		bestF.repaint();
		    		
				}
				panel.setList(fittestGeneration);
				
				newGeneration();
				
				
				
			 }
				else newGeneration();
				
				generation++;
			}
			
			
		}
	
	private double getFitness() {
		File f = new File("C://Users/Alex/Desktop/example_image.jpg");
		return ImgDiffPercent.getDiff(f, panel.getImage());
		}

	public void newGeneration(){
		
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) {
		new PolygonShapesMain();
	}
}

