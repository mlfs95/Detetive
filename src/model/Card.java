package model;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Card {

	private String name;
	private Image imageCard;
	private Type type;
	public enum Type {
		comodo, suspeito, arma;
	}
	
	public Card (String name, String path, int type){
		
		this.name = name;
		
		try
		{
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream(path);
			imageCard = ImageIO.read(input);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		if (type == 0){
			this.type = Type.comodo;
		}
		else if (type == 1){
			this.type = Type.suspeito;
		}
		else if (type == 2){
			this.type = Type.arma;
		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public Image getImage(){
		return imageCard;
	}
	
	public Type getType(){
		return type;
	}
}
