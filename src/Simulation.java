import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Simulation
{
	///////Constructor & attributes

	private int nbAnts;
	private int nbSources;
	private int nbTours;
	private int xMax;
	private int yMax;
	private Vector<Ant> colony;
	private Vector<FoodSource> foodSources;

	public Simulation(int nbAnts, int nbTours, int nbSources, int xMax, int yMax){
		
		Ant new_ant;
		FoodSource new_foodSource;
		Random alea = new Random();
		
		this.nbAnts = nbAnts;
		this.nbTours = nbTours;
		this.xMax = xMax;
		this.yMax = yMax;
		this.nbSources = nbSources;
		
		///Initial population generation

		this.colony = new Vector<Ant>(this.nbAnts);
		
		for(int i = 0; i<nbAnts; i++){
			new_ant = new Ant( alea.nextInt(this.xMax), alea.nextInt(this.yMax));
			new_ant.setDestination(alea.nextInt(this.xMax), alea.nextInt(this.yMax));
			if( ! (colony.add(new_ant) ))
				System.out.println("Error creating new ant");
		}
		///Initial foodSources generation

		this.foodSources = new Vector<FoodSource>();
		
		for(int i = 0; i<nbSources; i++){
			new_foodSource = new FoodSource( alea.nextInt(this.xMax), alea.nextInt(this.yMax));
			if( !(foodSources.add(new_foodSource) ))
				System.out.println("Error creating new foodSource");

		}	
	}
	
///////Accessors

	public int getNbAnts() {
		return this.nbAnts;
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

	public Vector<Ant> getColony(){
		return this.colony;
	}

	public Vector<FoodSource> getFoodSources(){
		return this.foodSources;
	}

	public void setNbTours(int new_nb){
		this.nbTours = new_nb;
	}

/////////Methods

	public void simule(){
		for (Ant ant : this.colony){
			//ant.print();
			ant.ageing();
			ant.move();
			ant.giveOrder(this.xMax, this.yMax);
		}

		for (FoodSource food : this.foodSources){
			if(food.getQuantity()<=0)
				foodSources.remove(food);
		}
	}

////////////////////////
////// MAIN ///////////
///////////////////////

	public static void main(String args[]){	
		
		int maxTurn = Integer.parseInt(args[1]);
		int antNb = Integer.parseInt(args[0]);

		Map map = new Map(antNb, maxTurn, 5, 1000, 1000);
		Interface frame = new Interface(map.getSimulation().getXMax(), map.getSimulation().getYMax());

		int end = map.getSimulation().getNbTours();

		frame.setContentPane(map);
		frame.setVisible(true);

		for(int i = 0; i<end ; i++){
			map.getSimulation().simule();
			//map.refresh();
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