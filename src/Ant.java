import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;


//////////////////////
////Ants Super-Class
/////////////////////

public class Ant
{

/////////Constructor and attributes

	protected int x;
	protected int y;
	protected int foodStock;
	protected int age;
	protected int[] destination;
	protected boolean idling;

	public Ant(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.foodStock= 100;
		this.age = 0;
		this.destination = new int[2];
		this.destination[0] = 0;
		this.destination[1] = 0;
		this.idling = false;
	}

////////Accessors

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getHunger(){
		return this.foodStock;
	}

	public int getAge(){
		return this.age;
	}

	public int[] getDestination(){
		return this.destination;
	}

	public boolean getIdling(){
		return this.idling;
	}

/////
	public void setX(int new_x){
		this.x = new_x;
	}

	public void setY(int new_y){
		this.y = new_y;
	}

	public void setHunger(int foodStock){
		this.foodStock = foodStock;
	}

	public void setAge(int age){
		this.age = age;
	}

	public void setDestination(int x, int y){
		this.destination[0]=x;
		this.destination[1]=y;
	}

	public void setIdling(boolean bool){
		this.idling = bool;
	}

/////Methods 
	public void ageing() {
		this.age++;
	}

	public void move() {
		///Move an ant toward its destination
		if(!this.idling){
			double norm = Math.sqrt((this.destination[0]-this.x)*(this.destination[0]-this.x) + (this.destination[1]-this.y)*(this.destination[1]-this.y) );
			double vx = (this.destination[0]-this.x)/norm;
			double vy = (this.destination[1]-this.y)/norm;
			this.y+=Math.round(vy);
			this.x+=Math.round(vx);
			if ((this.y==this.destination[1])&&(this.x==this.destination[0]))
				this.idling = true;
		}
	}

	public void giveOrder(int xmax, int ymax){
		///For now, give an ant a new destination if idling
		if(this.idling){
			Random alea = new Random();
			this.destination[0] = alea.nextInt(xmax);
			this.destination[1] = alea.nextInt(ymax);
			this.idling=false;
		}
	}

	///Food related :

	public void takeFood(FoodSource food){
		int hung = 100 - this.foodStock;
		this.foodStock = food.getQuantity()%100;
		food.setQuantity(food.getQuantity()-hung);
	}

	public void dropFood(Vector<FoodSource> foodSources){
		int drop = this.foodStock - 20;
		foodSources.add(new FoodSource(this.x, this.y));
		if(this.foodStock > 20)
			this.foodStock = 20;
		this.idling = true;  
	}

	public void detectFood(Vector<FoodSource> foodSources){

	}


///Misc
	public void print() {
		System.out.println("Ant : (x = " + this.x + ", y = " + this.y + "), Age : " + this.age + ", Dest : (" + this.destination[0] + ", " + this.destination[1] + ")");
	}
}