package model;

import java.util.ArrayList;
import java.util.List;

import main.Facade;
import screen.SuggestionScreen;

//import java.util.Observable;

public class SuggestionObserver implements Observer{
	
	//private List<Observer> observers = new ArrayList<Observer>();
	private SuggestionScreen s;

	public SuggestionObserver(){
		
	}
	
	
	@Override
	public void update() {
		//Facade f = Facade.getInstance();
		//f.InstanceSuggestionScreen();
		s = new SuggestionScreen("Palpite");
		s.setSize(250,250);
		s.setVisible(true);
		//System.out.println("UPDATE");
		
	}

}
