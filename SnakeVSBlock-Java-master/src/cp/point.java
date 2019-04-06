package cp;


import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


/**
 * The most basic basic collectible on which other collectibles are developed.
 * @author Himanshu and Kartikey
 *
 */
public class point {
		
	protected centre c;
	protected int radius;
	protected Circle circle;
	protected StackPane spane;
	
	/**
	 * Returns point object
	 * @param cen centre class object which determines position of that circle.
	 * @param rad integer which determines the radius of circle.
	 */
	point(centre cen,int rad)
	{
		c = cen;
		radius = rad;
		circle  = new Circle(rad);
		/*circle.setCenterX(c.getx()); 
	    circle.setCenterY(c.gety()); 
	    circle.setRadius(radius);*/
		spane = new StackPane();
		spane.setPrefHeight(20);
		spane.setPrefWidth(20);
		spane.getChildren().add(circle);
		spane.setLayoutX(c.getx());
		spane.setLayoutY(cen.gety());
	}
	
	/**
	 * 
	 * @return centre object holding information of the current position
	 */
	public centre getc()
	{
		return c;
	}
	
	/**
	 * Set position of the object
	 * @param cen centre object that determines the position to be set
	 */
	public void setc(centre  cen)
	{
		c = cen;
		spane.setLayoutX(cen.getx());
		spane.setLayoutY(cen.gety());
	}
	
	/**
	 * Set position of the object
	 * @param x X coordinate of new position
	 * @param y Y coordinate of new position
	 */
	public void setc(int x,int y)
	{
		c = new centre(x,y);
		spane.setLayoutX(x);
		spane.setLayoutY(y);
	}
	
	/**
	 * 
	 * @return radius of the object
	 */
	public int getradius()
	{
		return radius;
	}
	
	/**
	 * 
	 * @param rad new radius to be set
	 */
	public void setradius(int rad)
	{
		radius = rad;
	}	
}
