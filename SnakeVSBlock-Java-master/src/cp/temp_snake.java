package cp;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Class providing the snake instance 
 * @author Dinesh Kumari
 *
 */
public class temp_snake 
{
	static Random rand = new Random();
	private Circle head_ball;
	private ArrayList<Circle> saanp = new ArrayList<Circle>();
	private int has_shield=0;
	private int has_magnet=0;
	private int has_destroyer=0;
	
	/**
	 * Initialises snake with length 1
	 * @param pane main game screen layout which adds components into it.
	 */
	public temp_snake(Pane pane)
	{
		Circle temp = new Circle();
		temp.setRadius(10);
		temp.setFill(Color.RED);
		temp.setStroke(Color.BLACK);
		head_ball = temp;
		head_ball.setCenterY(330);
		saanp.add(temp);
		pane.getChildren().add(temp);
	}
	
	/**
	 * Initialises snake when game is resumed
	 * @param n length of snake in resumed game
	 * @param pane main game screen layout which adds components into it.
	 */
	public temp_snake(int n , Pane pane)
	{
		for(int i=0 ; i<n ; i++)
		{
			Circle temp = new Circle();
			temp.setRadius(10);
			temp.setFill(Color.RED);
			temp.setStroke(Color.BLACK);
			if(i==0)
				head_ball = temp;
			temp.setCenterY(330+i*20);
			saanp.add(temp);
			pane.getChildren().add(temp);
		}
	}
	
	/**
	 * 
	 * @return whether snake has propety magnet
	 */
	public boolean is_magnetic() {return has_magnet==1;}
	
	/**
	 * Enable property of collectible magnet
	 */
	public void give_magnet() {this.has_magnet=1;}
	
	/**
	 * Disable property of collectible shield
	 */
	public void take_magnet() {this.has_magnet=0;}
	
	/**
	 * 
	 * @return whether snake has propety destroyer
	 */
	public boolean is_destroyer() {return has_destroyer==1;}
	
	/**
	 * Enable property of collectible destroyer
	 */
	public void give_destroyer() {this.has_destroyer=1;}
	
	/**
	 * Disable property of collectible shield
	 */
	public void take_destroyer() {this.has_destroyer=0;}
	
	/**
	 * 
	 * @return whether snake has propety shield
	 * 	 
	 * */
	public boolean is_shielded()
	{
		return has_shield==1;
	}
	
	/**
	 * Enable property of collectible shield
	 */
	public void give_shield()
	{
		this.has_shield = 1;
	}
	
	/**
	 * Disable property of collectible shield
	 */
	public void take_shield()
	{
		this.has_shield = 0;
	}
	
	/**
	 * Set colour of snake to red
	 */
	public void set_red()
	{
		for(Circle temp : this.saanp) {
			temp.setFill(Color.RED);
		}
	}
	
	/**
	 * Randomly change colour of snake for certain duration of time.
	 */
	public void change_color()
	{
		int n = rand.nextInt(block.colors.length);
		for(Circle temp : this.saanp)
		{
			temp.setFill(block.colors[n]);
		}
	}
	
	/**
	 * Set colour of all the Circles in snake
	 * @param color Color type
	 */
	public void set_color(Paint color)
	{
		for(Circle temp : this.saanp)
		{
			temp.setFill(color);
		}
	}
	
	/**
	 * Add circles to snake / increases its length
	 * @param pane main game screen layout which adds components into it.
	 */
	public void add(Pane pane)
	{
		Circle temp = new Circle();
		temp.setRadius(10);
		temp.setCenterY(head_ball.getCenterY()+saanp.size()*20);
		temp.setCenterX(head_ball.getCenterX());
		temp.setStroke(Color.BLACK);
		temp.setFill(Color.RED);
		saanp.add(temp);
		pane.getChildren().add(temp);
	}
	
	/**
	 * Move whole snake
	 */
	public void move_snake()
	{
		for(Circle temp : saanp) {
			temp.setCenterX(head_ball.getCenterX());
		}
	}
	
	/**
	 * Remove last circle from snake
	 * @param pane main game screen layout which adds components into it.
	 */
	public void remove(Pane pane)
	{
		Circle c = saanp.get(saanp.size()-1);
        pane.getChildren().remove(c);
        saanp.remove(saanp.size() - 1);
	}
	
	/**
	 * Remove all circles from snake / kill snake
	 * @param pane main game screen layout which adds components into it.
	 */
	public void empty_it(Pane pane)
	{
		for(int i=0 ; i<saanp.size() ; i++) {
			pane.getChildren().remove(saanp.get(i));
		}
		saanp.clear();
	}
	
	/**
	 * Reduce length of snake
	 * @param n number of circles to be reduced from snake length
	 * @param pane main game screen layout which adds components into it.
	 */
	public void cut_short(int n , Pane pane)
	{
		System.out.println("entered cutshort");
		for(int i=0 ; i<n ; i++)
		{
			Circle c = saanp.get(saanp.size()-1);
			saanp.remove(c);
			pane.getChildren().remove(c);
		}
		System.out.println("done");
	}
	
	/**
	 * 
	 * @return length of snake
	 */
	public int len()
	{
		return this.saanp.size();
	}
	
	/**
	 * Move head of snake
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public void set_coordinate_of_head(int x , int y)
	{
		head_ball.setCenterX(x);
		head_ball.setCenterY(y);
	}
	
	/**
	 * 
	 * @return head circle of snake
	 */
	public Circle ret_head_ball()
	{
		return head_ball;
	}
}
