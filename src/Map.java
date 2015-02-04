import java.lang.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Map extends JPanel {
	
  private Vector<Ant> colony;

  public Map(){
    this.colony = new Vector<Ant>();
  }

  @Override
	public void paintComponent(Graphics g) {
    super.paintComponents(g);
    for(Ant ant : this.colony)
      g.fillRect(ant.getX(), ant.getY(), 4, 4);
	}

    public void setColony(Vector<Ant> colony){
      this.colony = new Vector<Ant>();
      for(Ant ant : colony)
        this.colony.add(ant);
    }

    public void erase(){
        this.colony = new Vector<Ant>();
        repaint();
    }

    public void refresh(Vector<Ant> colony){
      this.erase();
      this.setColony(colony);
      this.repaint();
    }
}