import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiceScreen extends JFrame implements ActionListener {
	private static DiceScreen instance = null;
	private int DieValue1;
	private int DieValue2;
	private JLabel label1,label2;
	private JTextField text1,text2;
	private JButton button;
	private Container janela;
	
	public DiceScreen(){
		super();
		janela = getContentPane();
		//janela.setLayout(new GridLayout(2,2,1,1));
		janela.setLayout(null);
	//	label1 = new JLabel("Valor do dado 1",JLabel.RIGHT);
		label1 = new JLabel("Valor do dado 1");
		label1.setBounds(50, 40, 100, 20);
		
		//label2 = new JLabel("Valor do dado 2",JLabel.RIGHT);
		label2 = new JLabel("Valor do dado 2");
		label2.setBounds(50, 80, 100, 20);
		
		text1 = new JTextField();
		text2 = new JTextField();
		text1.setBounds(150, 40, 50, 20);
		text2.setBounds(150, 80, 50, 20);
		
		janela.add(label1);
		janela.add(label2);
		janela.add(text1);
		janela.add(text2);
		janela.add(button = new JButton("OK"));
		
		button.setBounds(100,130,80,80);
		//getRootPane().setDefaultButton(button);
		//setSize(400,250);
		
		text1.addActionListener(this);
		text2.addActionListener(this);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();
       // setVisible(true);
	}
	
	public int getDie1(){
		return DieValue1;
	}
	
	public int getDie2(){
		return DieValue2;
	}
	
	public int getDice(){
		return DieValue1+DieValue2;
	}
	
	public static DiceScreen getInstance(){
		if(instance == null){
			instance = new DiceScreen();
		}
		
		return instance;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button){
			try{
				DieValue1 = Integer.parseInt(text1.getText());
				DieValue2 = Integer.parseInt(text2.getText());
			} catch(NumberFormatException nfe){
				System.out.println("formato incorreto");
			}
			
			FRDice f = new FRDice(DieValue1, DieValue2);//PNDice(DieValue1, DieValue2);
			f.setSize(600,600);
			f.setVisible(true);
		}
		else{
			System.exit(1);
		}
		
	}
	
}
