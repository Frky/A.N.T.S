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
	protected int hunger;
	protected int age;

	public Ant(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.hunger= 100;
		this.age = 0;
	}

////////Accessors

	public int getX() 
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public int getHunger()
	{
		return this.hunger;
	}

	public int getAge()
	{
		return this.age;
	}

/////
	public void setX(int new_x)
	{
		this.x = new_x;
	}

	public void setY(int new_y)
	{
		this.y = new_y;
	}

	public void setHunger(int hunger)
	{
		this.hunger = hunger;
	}

	public void setAge(int age)
	{
		this.age = age;
	}


/////Methods 

	public void getOld()
	{
		this.age++;
	}

	public void print()
	{
		System.out.println("Ant : (x = " + this.x + ", y = " + this.y + "), Age : " + this.age);
	}
}