import java.lang.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Interface extends JFrame{
	
	public Interface(int x, int y){

		this.setTitle("Simulation");
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}