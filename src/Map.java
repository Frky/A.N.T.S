import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class Map extends JPanel {
	
  private Vector<Ant> collection = new Vector<Ant>();

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
    for(Ant ant : this.collection)
      g.fillRect(ant.getX(), ant.getY(), 4, 4);
	}

    public void setCollection(Vector<Ant> collection){
      if(this.collection.capacity()!=0)
        this.collection.clear();
      for(Ant ant : collection)
        this.collection.add(ant);
    }

}