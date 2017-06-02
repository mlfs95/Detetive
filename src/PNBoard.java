import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PNBoard extends JPanel{
	
	private Image i;
	
	public PNBoard(int width, int height){
		
		this.setSize(width, height);
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Tabuleiro-Original.jpg");
			i = ImageIO.read(input);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(i, 0, 0, null); // see javadoc for more info on the parameters            
	    }
}
