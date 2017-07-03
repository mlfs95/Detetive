package screen;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Player;

public class AnotationsScreen extends JFrame {
	
	private JLabel[] labels;// = new JLabel[21];
	private Container screen;
	private int i = 0,pos = 20;
	private boolean comodos[];
	private boolean suspeitos[];
	private boolean armas[];
	private String comodosnomes[];
	private String suspeitosnomes[];
	private String armasnomes[];
	//private static AnotationsScreen instance;
	
	public AnotationsScreen(Player player,String s){
		super(s);
		
		screen = getContentPane();
		screen.setLayout(null);
		
		comodos = player.getAnotations().getComodos();
		suspeitos = player.getAnotations().getSuspeitos();
		armas = player.getAnotations().getArmas();
		comodosnomes = player.getAnotations().getNomecomodos();
		suspeitosnomes = player.getAnotations().getNomessuspeitos();
		armasnomes = player.getAnotations().getNomesarmas();
		
		for(int cont = 0; cont < 6; cont++){
			if(suspeitos[cont] == true){
				labels[i] = new JLabel(suspeitosnomes[cont]);
				labels[i].setBounds(20, pos, 50, 50);
				i++;
				pos = pos + 20;
			}
		}
		
		for(int cont = 0; cont < 9; cont++){
			if(comodos[cont] == true){
				labels[i] = new JLabel(comodosnomes[cont]);
				labels[i].setBounds(20, pos, 50, 50);
				i++;
				pos = pos + 20;
			}
		}
		
		for(int cont = 0; cont < 6; cont++){
			if(armas[cont] == true){
				labels[i] = new JLabel(armasnomes[cont]);
				labels[i].setBounds(20, pos, 50, 50);
				i++;
				pos = pos + 20;
			}
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
/*	public static AnotationsScreen getInstance(Player p){
		if(instance == null){
			instance = new AnotationsScreen(p);
		}
		return instance;
	} */

}
