package screen;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PNDice extends JPanel{
	
	private Image i1,i2;
	private String path1,path2;

	public PNDice(int die1, int die2){
		
		switch(die1){
		
		case 1:
			path1 = "dado1.jpg";
			break;
		case 2:
			path1 = "dado2.jpg";
			break;
		case 3:
			path1 = "dado3.jpg";
			break;
		case 4:
			path1 = "dado4.jpg";
			break;
		case 5:
			path1 = "dado5.jpg";
			break;
		case 6:
			path1 = "dado6.jpg";
			break;
		default:
			System.out.println("Valor inválido");
		}
		
		switch(die2){
		
		case 1:
			path2 = "dado1.jpg";
			break;
		case 2:
			path2 = "dado2.jpg";
			break;
		case 3:
			path2 = "dado3.jpg";
			break;
		case 4:
			path2 = "dado4.jpg";
			break;
		case 5:
			path2 = "dado5.jpg";
			break;
		case 6:
			path2 = "dado6.jpg";
			break;
		default:
			System.out.println("Valor inválido");
		}
		
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input1 = classLoader.getResourceAsStream(path1);
			i1 = ImageIO.read(input1);
			InputStream input2 = classLoader.getResourceAsStream(path2);
			i2 = ImageIO.read(input2);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		} 
		
		
	}
	
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(i1, 0, 0, null);
	        g.drawImage(i2,100, 0, null);// see javadoc for more info on the parameters            
	    } 
} 
