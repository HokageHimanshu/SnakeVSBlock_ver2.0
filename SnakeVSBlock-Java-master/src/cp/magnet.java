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
	public class magnet
	{
		static Random rand = new Random();
		int value;
		ArrayList<point> magnets = new ArrayList<point>();

		/**
		 * Returns magnet collectible at random position.
		 * @param pane main game screen layout which adds components into it.
		 */
		public magnet(Pane pane)
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
				point temp = new point(new centre(positions.get(i)*45-10,-1820),13);
				magnets.add(temp);
				Rectangle cir = new Rectangle();
				cir.setHeight(5);
				cir.setWidth(5);
				cir.setStroke(Color.BLACK);
				cir.setFill(Color.DARKBLUE);
				temp.spane.getChildren().add(cir);
				pane.getChildren().add(temp.spane);
				temp.circle.setStroke(Color.BLACK);
				temp.circle.setFill(Color.GREENYELLOW);
			}
		}
		
		/**
		 * Returns magnet collectible from saved game data.
		 * @param pos Position of magnet
		 * @param y Y coordinate of magnet
		 * @param pane main game screen layout which adds components into it.
		 */
		public magnet(ArrayList<Double> pos , int y , Pane pane)
		{
			for(int i=0 ; i<pos.size() ; i++)
			{
				point temp = new point(new centre(pos.get(i).intValue(),y),13);
				magnets.add(temp);
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
			return magnets.get(0).c.gety();
		}
		
		/**
		 * Moves magnet downward
		 * @param y Y coordinate to which wall needs to be moved
		 * @param pane main game screen layout which adds components into it.
		 */
		public void translate(int y , Pane pane)
		{
			for(point temp : magnets)
			{
				if(pane.getChildren().contains(temp.spane))
					temp.setc(new centre(temp.c.getx(),y));
			}
		}
	}
