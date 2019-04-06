package cp;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Provides the coins that snake eats and increase its length.
 * @author Himanshu and Kartikey
 *
 */
public class ball
{
	static Random rand = new Random();
	ArrayList<Text> text;
	ArrayList<point> balls = new ArrayList<point>();
/**
 * Initialises coins with random values and random positions.
 * @param pane main game screen layout which adds components into it.
 */
	public ball(Pane pane)
	{
		int n = rand.nextInt(4)+1;
		text = new ArrayList<Text>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for(int i=0 ; i<n ; i++)
		{
			Text temp = new Text(Integer.toString(rand.nextInt(8)+1));
			temp.setStyle("-fx-font-weight: bold");
			text.add(temp);
			int j = rand.nextInt(4);
			System.out.println("position : "+j);
			while(!positions.isEmpty() && positions.contains(2*j+1))
				j = rand.nextInt(4);
			positions.add(2*j+1);
			System.out.println("pos balls "+positions);
		}
		for(int i=0 ; i<n ; i++)
		{
			point temp = new point(new centre(positions.get(i)*45-10,-50),13);
			balls.add(temp);
			temp.spane.getChildren().add(text.get(i));
			pane.getChildren().add(temp.spane);
			temp.circle.setStroke(Color.BLACK);
			temp.circle.setFill(Color.YELLOW);
		}
	}
	
/**
 * Uses saved game data to inialise coins on resuming game.
 * @param pos ArrayList of positions of saved state coins.
 * @param val ArrayList of values of saved state coins.
 * @param y coordinate of all coins of saved state coins.
 * @param pane main game screen layout which adds components into it.
 */
	public ball(ArrayList<Double> pos, ArrayList<Integer> val , int y ,Pane pane)
	{
		text = new ArrayList<Text>();
		for(int t : val)
		{
			Text temp = new Text(Integer.toString(t));
			temp.setStyle("-fx-font-weight: bold");
			text.add(temp);
		}
		for(int i=0 ; i<pos.size() ; i++)
		{
			point temp = new point(new centre(pos.get(i).intValue(),y),13);
			balls.add(temp);
			temp.spane.getChildren().add(text.get(i));
			pane.getChildren().add(temp.spane);
			temp.circle.setStroke(Color.BLACK);
			temp.circle.setFill(Color.YELLOW);	
		}
	}
	
	/**
	 * 
	 * @return y coordinate of all coins in ArrayList
	 */
	public int getY()
	{
		if(!balls.isEmpty())
			return balls.get(0).c.gety();
		else
			return -1;
	}
	
	/**
	 * Moves set of coins downward.
	 * @param y coordinate to which all coins in ArrayList should move
	 * @param pane main game screen layout which adds components into it.
	 */
	public void translate(int y,Pane pane)
	{
		if(balls.isEmpty())
			return;
		for(point temp : balls)
		{
			if(pane.getChildren().contains(temp.spane))
				temp.setc(new centre(temp.c.getx(),y));
		}
	}
	
}
