import java.lang.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Map extends JPanel {
	
  private Simulation simulation;

  public Map(int nbAnt, int nbTours, int nbSources, int xMax, int yMax){
    this.simulation = new Simulation(nbAnt, nbTours, nbSources, xMax, yMax);
  }

  @Override
	public void paintComponent(Graphics g) {
    
    Color darkGreen = new Color(0,128,0);

    super.paintComponents(g);
    g.setColor(Color.darkGray);
    g.drawOval(this.simulation.getXMax()/2-75,this.simulation.getYMax()/2-75,150,150);
    for(Ant ant : this.simulation.getColony())
      g.fillRect(ant.getX(), ant.getY(), 4, 4); 
    g.setColor(darkGreen);
    for(FoodSource food : this.simulation.getFoodSources())
      g.fillOval(food.getX()-12, food.getY()-12, food.getQuantity()/100, food.getQuantity()/100);
	}

    public void setSimulation(Simulation simulation){
      this.simulation = simulation;
    }

    public Simulation getSimulation(){
      return this.simulation;
    }

    public void refresh(){
      this.repaint();
    }
}