package cp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Provides list of walls whom snake cant cross
 * @author Dinesh Kumari
 *
 */
public class wall
{
	static Random rand = new Random();
	ArrayList<Rectangle> dande;
	
	/**
	 * Initialises randomly ordered Rectangle wall list
	 * @param pane main game screen layout which adds components into it.
	 */
	public wall(Pane pane)
	{
		dande = new ArrayList<Rectangle>();
		int n = rand.nextInt(4)+1;
		System.out.println("n : "+n);
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for(int i=0 ; i<n ; i++)
		{
			int j = rand.nextInt(4)+1;
			System.out.println("positions : "+j);
			positions.add(j);
		}
		Collections.sort(positions);
		for(int i=0 ; i<n ; i++)
		{
			Rectangle temp = new Rectangle();
			temp.setLayoutX(positions.get(i)*90);
			temp.setLayoutY(-110);
			dande.add(temp);
			temp.setWidth(2);
			temp.setHeight(150);
			pane.getChildren().add(temp);
			temp.setStroke(Color.BLACK);
			temp.setFill(Color.WHITE);
		}
	}
	
	/**
	 * Initialises wall list according to save game state
	 * @param pos ArrayList of positions of each wall
	 * @param y Y coordinate of all walls at the time of save
	 * @param pane main game screen layout which adds components into it.
	 */
	public wall(ArrayList<Double> pos , int y ,Pane pane)
	{	
		dande = new ArrayList<Rectangle>();
		for(int i=0 ; i<pos.size() ; i++)
		{
			Rectangle temp = new Rectangle();
			temp.setLayoutX(pos.get(i));
			temp.setLayoutY(y+90);
			dande.add(temp);
			temp.setWidth(2);
			temp.setHeight(150);
			pane.getChildren().add(temp);
			temp.setStroke(Color.BLACK);
			temp.setFill(Color.WHITE);
		}
	}
	
	/**
	 * Moves shield downward
	 * @param y Y coordinate to which wall needs to be moved
	 * @param pane main game screen layout which adds components into it.
	 */
	public void translate(int y , Pane pane)
	{
		for(Rectangle temp : dande)
		{
			if(pane.getChildren().contains(temp))
				temp.setLayoutY(y);
		}
	}
	
	/**
	 * 
	 * @return Y coordinate of all blocks in wall
	 */
	public int getY()
	{
		if(!dande.isEmpty())
			return (int)dande.get(0).getLayoutY();
		else
			return -1;
	}
	
}
