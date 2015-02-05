public class FoodSource{

///Constructors & attributes

	private int quantity;
	private int x;
	private int y;

	public FoodSource(int x,int y)
	{
		this.quantity = 100;
		this.x = x;
		this.y = y;
	}

///Accessors

	public int getQuantity(){
		return this.quantity;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void setQuantity(int q){
		this.quantity = q;
	}
}