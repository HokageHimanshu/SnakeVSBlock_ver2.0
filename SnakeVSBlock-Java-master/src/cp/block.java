package cp;

import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Returns single block for collision
 * @author Himanshu and Kartikey
 *
 */
public class block 
{
	static Random rand = new Random();
	static Paint[] colors = {Color.BLUEVIOLET , Color.AQUA , Color.GREEN , Color.GREENYELLOW , Color.YELLOW , Color.BROWN , Color.CHOCOLATE};
	public StackPane pane;
	public Text text;
	public Rectangle box;
	
	/**
	 * Returns single block after setting up colour.
	 */
	public block()
	{
		pane = new StackPane();
		text = new Text();
		box = new Rectangle();
		pane.setPrefHeight(90);
		pane.setPrefWidth(90);
		box.setHeight(90);
		box.setWidth(90);
		text.setStyle("-fx-font: 28 arial;");
		box.setFill(colors[rand.nextInt(7)]);
		box.setStroke(Color.BLACK);
		pane.getChildren().add(box);
		pane.getChildren().add(text);
		box.setArcHeight(15);
		box.setArcWidth(15);
	}
	
	/**
	 * Add this object to the game screen pane.
	 * @param pane main game screen layout which adds components into it.
	 */
	void add(Pane pane)
	{
		pane.getChildren().add(this.pane);
	}
	
	/**
	 * 
	 * @return StackPane of this block
	 */
	public Pane ret_pane()
	{
		return this.pane;
	}
	
	/**
	 * Set the colour of this block
	 * @param paint value of colour to fill in block
	 */
	public void set_color(Paint paint)
	{
		this.box.setFill(paint);
	}
	
	/**
	 * Set position to a certain coordinate.
	 * @param x X coordinate of desired new position.
	 * @param y Y coordinate of desired new position.
	 */
	public void set_position(int x ,int y)
	{
		pane.setLayoutX(x);
		pane.setLayoutY(y);
	}
	
	/**
	 * Move the block downward
	 * @param y Y coordinate to which block is to be moved.
	 */
	public void translate(int y)
	{
		this.pane.setLayoutY(y);
	}
	
	/**
	 * Set the value of the block
	 * @param a Value to be set
	 */
	public void set_text(int a)
	{
		this.text.setText(Integer.toString(a));
	}
	
	/**
	 * 
	 * @return current Y coordinate of block
	 */
	public int retY()
	{
		return (int)pane.getLayoutY();
	}
}
