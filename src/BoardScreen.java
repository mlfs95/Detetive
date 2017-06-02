import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BoardScreen extends JFrame{
	
	public static BoardScreen instancia = null;
	
	public BoardScreen(String s, int width, int height){
		
		super(s);
		
		PNBoard p = new PNBoard(width,height);
		getContentPane().add(p);
	
		
	}
	
	public static BoardScreen getInstance(){
		if(instancia == null){
			instancia = new BoardScreen("Detetive",600,600);
		} 
		return instancia;
	}
	
	private int rollDices() {
		
		Random randomGenerator = new Random();
		int diceNumber = randomGenerator.nextInt(6)+1;
		
		//JLabel image = new JLabel;
		
		return diceNumber;
	}

}
