package cp;

import java.util.ArrayList;
import java.util.Random;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;



/**
 * This class provides a wall of blocks and all the associated properties.
 * @author Himanshu and Kartik
 *
 */
public class block_wall 
{
	static Random rand = new Random();
	
	ArrayList<block> wall = new ArrayList<block>();
	
	/**
	 * Returns a wall of randomly ordered blocks with random values.
	 * @param snake_length length of snake at the time of initialisation.
	 * @param pane main game screen layout which adds components into it.
	 */
	public block_wall(int snake_length , Pane pane)
	{
		int n = rand.nextInt(4)+2;
		System.out.println("n="+n);
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for(int i=0 ; i<n ; i++)
		{
			int j = rand.nextInt(5);
			while(!positions.isEmpty() && positions.contains(j))
				j = rand.nextInt(5);
			System.out.println("positions : "+j);
			positions.add(j);
			System.out.println("positions blocks "+positions);
		}
		int ind = rand.nextInt(n);
		System.out.println("index : "+ind);
		for(int i=0 ; i<n ; i++)
		{
			block temp = new block();
			temp.set_position(positions.get(i)*90, -200);
			wall.add(temp);
			pane.getChildren().add(temp.ret_pane());
			if(ind == i && snake_length>1)
				temp.set_text(rand.nextInt(snake_length-1)+1);
			else
				temp.set_text(rand.nextInt(25)+1);
		}
	}
	
	/**
	 * Return the wall of blocks as saved during game save.
	 * @param pos ArrayList of positions of individual blocks in saved game.
	 * @param color ArrayList of color of individual blocks in saved game
	 * @param value ArrayList of value of individual blocks in saved game
	 * @param y Y coordinate of all individual blocks at the time of save.
	 * @param pane pane main game screen layout which adds components into it.
	 */
	public block_wall(ArrayList<Double> pos , ArrayList<String> color , ArrayList<String> value, int y , Pane pane)
	{
		for(int i=0 ; i<pos.size() ; i++)
		{
			block temp = new block();
			temp.box.setFill(Paint.valueOf(color.get(i)));
			temp.set_position(pos.get(i).intValue(),y);
			wall.add(temp);
			pane.getChildren().add(temp.ret_pane());
			temp.set_text(Integer.parseInt(value.get(i)));
		}
	}
	/**
	 * 
	 * @return Y coordinate of all blocks in wall
	 */
	public int getY()
	{
			return wall.get(0).retY();
	}
	
	/**
	 * Moves wall of blocks downward
	 * @param y Y coordinate to which wall needs to be moved
	 * @param pane main game screen layout which adds components into it.
	 */
	public void translate(int y,Pane pane)
	{
		for(block temp : wall)
		{
			if(pane.getChildren().contains(temp.pane))
				temp.translate(y);
		}
	}
}
