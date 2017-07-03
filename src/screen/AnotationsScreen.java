package screen;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;

public class AnotationsScreen extends JFrame {
	
	private JLabel labels[] = new JLabel[21];
	private Container screen;
	private int i = 0,pos = 20;
	private boolean comodos[];
	private boolean suspeitos[];
	private boolean armas[];
	private String comodosnomes[];
	private String suspeitosnomes[];
	private String armasnomes[];
	//private static AnotationsScreen instance;
	
	public AnotationsScreen(Player player,String s, int width, int height){
		super(s);
		System.out.println("entrei na anotation");
		screen = getContentPane();
		screen.setLayout(null);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(width, height);
		getContentPane().add(p);
		
		comodos = player.getAnotations().getComodos();
		suspeitos = player.getAnotations().getSuspeitos();
		armas = player.getAnotations().getArmas();
		comodosnomes = player.getAnotations().getNomecomodos();
		suspeitosnomes = player.getAnotations().getNomessuspeitos();
		armasnomes = player.getAnotations().getNomesarmas();
		
		for(int cont = 0; cont < 6; cont++){
			if(suspeitos[cont] == true){
				
				JLabel label = new JLabel(suspeitosnomes[cont]);
				label.setBounds(20, pos, 250, 50);
				i++;
				pos = pos + 20;
				System.out.println(label.getText());
				p.add(label);
			}
		}
		
		for(int cont = 0; cont < 9; cont++){
			if(comodos[cont] == true){
				JLabel label = new JLabel(comodosnomes[cont]);
				label.setBounds(20, pos, 250, 50);
				i++;
				pos = pos + 20;
				p.add(label);
			}
		}
		
		for(int cont = 0; cont < 6; cont++){
			if(armas[cont] == true){
				JLabel label = new JLabel(armasnomes[cont]);
				label.setBounds(20, pos, 250, 50);
				i++;
				pos = pos + 20;
				p.add(label);
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
