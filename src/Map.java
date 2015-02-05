import java.lang.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Map extends JPanel {
	
  private Simulation simulation;

  public Map(int nbAnt, int nbTours, int xMax, int yMax){
    this.simulation = new Simulation(nbAnt, nbTours, xMax, yMax);
  }

  @Override
	public void paintComponent(Graphics g) {
    super.paintComponents(g);
    g.drawOval(500,500,100,100);
    for(Ant ant : this.simulation.getColony())
      g.fillRect(ant.getX(), ant.getY(), 4, 4);
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