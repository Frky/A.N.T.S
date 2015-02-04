import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Simulation
{
	///////Constructor & attributes

	private int nbAnt;
	private int nbTours;
	private int xMax;
	private int yMax;
	private Vector<Ant> collection;

	public Simulation(int nbAnt, int nbTours, int xMax, int yMax){
		
		Ant new_ant;
		Random alea = new Random();
		this.nbAnt = nbAnt;
		this.nbTours = nbTours;
		this.xMax = xMax;
		this.yMax = yMax;
		this.collection = new Vector<Ant>(this.nbAnt);
		
		for(int i = 0; i<nbAnt; i++){
			new_ant = new Ant( alea.nextInt(this.xMax), alea.nextInt(this.yMax));
			new_ant.setDestination(alea.nextInt(this.xMax), alea.nextInt(this.yMax));
			if( ! (collection.add(new_ant) ))
				System.out.println("Error creating new ant");
		}	
	}
	
///////Accesseurs

	public int getNbAnt() {
		return this.nbAnt;
	}

	public int getNbTours() {
		return this.nbTours;
	}

	public int getXMax() {
		return this.xMax;
	}

	public int getYMax() {
		return this.yMax;
	}

	public void setNbTours(int new_nb){
		this.nbTours = new_nb;
	}

/////////Methods

	public void simule(){
		
		for (Ant ant : this.collection){
			//ant.print();
			ant.getOld();
			ant.move();
			ant.giveOrder(this.xMax, this.yMax);
		}
	}

////////////////////////
////// MAIN ///////////
	/////////////////

	public static void main(String args[]){	
		
		int maxTurn = Integer.parseInt(args[1]);
		int antNb = Integer.parseInt(args[0]);

		Simulation current_simu = new Simulation(antNb, maxTurn, 800, 600);
		int nb_tours_max = current_simu.getNbTours();
		
		Interface frame = new Interface(current_simu.getXMax(), current_simu.getYMax());
		Map map = new Map();


		map.setCollection(current_simu.collection);
      	frame.setContentPane(map);
    	frame.setVisible(true);

		for(int i = 0; i< nb_tours_max; i++){
			current_simu.simule();
			map.refresh(current_simu.collection);
			frame.getContentPane().removeAll();
			frame.setContentPane(map);
			frame.revalidate();
			try {
    			Thread.sleep(41);
			} 
			catch(InterruptedException ex) {
    			Thread.currentThread().interrupt();
			}
		}
	}
}