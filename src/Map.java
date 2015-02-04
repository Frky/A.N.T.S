import java.lang.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Map extends JPanel {
	
  private Vector<Ant> collection;

  public Map(){
    this.collection = new Vector<Ant>();
  }

  @Override
	public void paintComponent(Graphics g) {
    super.paintComponents(g);
    for(Ant ant : this.collection)
      g.fillRect(ant.getX(), ant.getY(), 4, 4);
	}

    public void setCollection(Vector<Ant> collection){
      this.collection = new Vector<Ant>();
      for(Ant ant : collection)
        this.collection.add(ant);
    }

    public void erase(){
        this.collection = new Vector<Ant>();
        repaint();
    }

    public void refresh(Vector<Ant> collection){
      this.erase();
      this.setCollection(collection);
      this.repaint();
    }
}