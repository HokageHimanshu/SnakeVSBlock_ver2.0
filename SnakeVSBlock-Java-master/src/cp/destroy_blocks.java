package cp;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


	/**
	 * Class of block destroyer collectible.
	 * @author Himanshu and Kartikey
	 *
	 */
	public class destroy_blocks
	{
		static Random rand = new Random();
		int value;
		ArrayList<point> destroy_blocks = new ArrayList<point>();

		/**
		 * Returns block destroyer collectoble at random position.
		 * @param pane main game screen layout which adds components into it.
		 */
		public destroy_blocks(Pane pane)
		{
			int n = 1;
			ArrayList<Integer> positions = new ArrayList<Integer>();
			for(int i=0 ; i<n ; i++)
			{
				int j = rand.nextInt(4);
				System.out.println("positions : "+j);
				positions.add(2*j+1);
			}
			for(int i=0 ; i<n ; i++)
			{
				point temp = new point(new centre(positions.get(i)*45-10,-1380),13);
				destroy_blocks.add(temp);
				pane.getChildren().add(temp.spane);
				temp.circle.setStroke(Color.BLACK);
				temp.circle.setFill(Color.CYAN);
			}
		}
		
		/**
		 * Returns block destroyer collectible from saved game data.
		 * @param pos Position of block destroyer
		 * @param y Y coordinate of block destroyer
		 * @param pane main game screen layout which adds components into it.
		 */
		public destroy_blocks(ArrayList<Double> pos , int y , Pane pane)
		{
			for(int i=0 ; i<pos.size() ; i++)
			{
				point temp = new point(new centre(pos.get(i).intValue(),y),13);
				destroy_blocks.add(temp);
				pane.getChildren().add(temp.spane);
				temp.circle.setStroke(Color.BLACK);
				temp.circle.setFill(Color.CYAN);
			}
		}
		
		/**
		 * 
		 * @return Y coordinate of all blocks in wall
		 */
		public int getY()
		{
			return destroy_blocks.get(0).c.gety();
		}
		
		/**
		 * Moves block destroyer downward
		 * @param y Y coordinate to which wall needs to be moved
		 * @param pane main game screen layout which adds components into it.
		 */
		public void translate(int y , Pane pane)
		{
			for(point temp : destroy_blocks)
			{
				if(pane.getChildren().contains(temp.spane))
					temp.setc(new centre(temp.c.getx(),y));
			}
		}
	}
