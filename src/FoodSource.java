public class FoodSource{

///Constructors & attributes

	private int quantity;
	private int x;
	private int y;
	private boolean forageable;

	public FoodSource(int q, int x, int y, boolean forageable)
	{
		this.quantity = q;
		this.x = x;
		this.y = y;
		this.forageable=forageable;
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

	public boolean isForageable(){
		return this.forageable;
	}
}