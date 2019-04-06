package cp;


/**
 * This class is used for maintaing the set of coordinates of the centre (of ball, block etc)
 * @author Himanshu and Kartikey
 */
public class centre {
	private int x;
	private int y;
	
	/**
	 * The constructor initialises the values of the x and y coordinate to the values passed as the arguments
	 * @param xcor is the x coordinate
	 * @param ycor is the y coordinate
	 */
	
	centre(int xcor,int ycor)
	{
		x = xcor;
		y = ycor;
	}
	
	/**
	 * @return It returns the x coordinate stored
	 */
	
	public int getx()
	{
		return x;
	}
	
	/**
	 * @return It returns the y coordinate stored
	 */
	public int gety()
	{
		return y;
	}
	
	/**
	 * It sets the x coordinate equals to the value passed as the argument
	 * @param xcor is the x coordinate value
	 */
	public void setx(int xcor)
	{
		x = xcor;
	}
	
	/**
	 * It sets the y coordinate equals to the value passed as the argument
	 * @param ycor is the y coordinate value
	 */
	public void sety(int ycor)
	{
		y = ycor;
	}

}
