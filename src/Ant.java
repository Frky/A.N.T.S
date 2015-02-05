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
	protected int[] colonyCoord;
	protected int[] destination;
	protected int[] detectedFood;
	protected boolean idling;

	public Ant(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.foodStock= 20;
		this.age = 0;
		this.destination = new int[2];
		this.detectedFood = new int[2];
		this.detectedFood[0] = -1;
		this.colonyCoord = new int[2];
		this.idling = true;
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

	public int[] getColonyCoord(){
		return this.colonyCoord;
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

	public void setColonyCoord(int x, int y){
		this.colonyCoord[0]=x;
		this.colonyCoord[1]=y;
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

	public void scout(int xmax, int ymax){
		///For now, give an ant a new destination if idling
		if(this.idling){
			Random alea = new Random();
			this.destination[0] = Math.min(Math.abs(this.getX()+alea.nextInt(200)-100),xmax);
			this.destination[1] = Math.min(Math.abs(this.getY()+alea.nextInt(200)-100),ymax);
			this.idling=false;
		}
	}

	///Food related :

	public void takeFood(FoodSource food){
		int hung = 100 - this.foodStock;
		this.foodStock = food.getQuantity()%100;
		food.setQuantity(food.getQuantity()-hung);
		if(food.getQuantity()<=0){
			this.detectedFood[0] = -1;
		}
	}

	public void dropFood(Vector<FoodSource> foodSources){
		if(this.detectedFood[0]!=-1){
			if((Math.abs(colonyCoord[0]-this.getX())<50)&&(Math.abs(colonyCoord[1]-this.getY())<50)){
				if(this.foodStock > 20){
					//int drop = this.foodStock - 20;
					foodSources.add(new FoodSource(100, this.x, this.y, false));
					this.foodStock = 0;
				}
				this.destination[0]=this.detectedFood[0];
				this.destination[1]=this.detectedFood[1];
			}
		}
	}

	public void detectFood(Vector<FoodSource> foodSources){
		Random alea = new Random();
		for(FoodSource food : foodSources){
			if( ( (Math.abs(food.getX()-this.getX())<25)&&(Math.abs(food.getY()-this.getY())<25) )&&(food.isForageable())){
				this.takeFood(food);
				this.detectedFood[0]=food.getX();
				this.detectedFood[1]=food.getY();
				this.destination[0]=this.colonyCoord[0]+alea.nextInt(100)-50;
				this.destination[1]=this.colonyCoord[1]+alea.nextInt(100)-50;
				this.idling=false;
			}
		}
	}


///Misc
	public void print() {
		System.out.println("Ant : (x = " + this.x + ", y = " + this.y + "), Age : " + this.age + ", Dest : (" + this.destination[0] + ", " + this.destination[1] + ")");
	}
}