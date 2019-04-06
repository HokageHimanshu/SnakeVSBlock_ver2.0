package cp;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


/**
 * Class of shield destroyer collectible.
 * @author Himanshu and Kartikey
 *
 */
	public class shield
	{
		static Random rand = new Random();
		int value;
		ArrayList<point> shields = new ArrayList<point>();

		/**
		 * Returns shield collectible at random position.
		 * @param pane main game screen layout which adds components into it.
		 */
		public shield(Pane pane)
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
				point temp = new point(new centre(positions.get(i)*45-10,-1320),13);
				shields.add(temp);
				Circle cir = new Circle(7);
				cir.setStroke(Color.BLACK);
				cir.setFill(Color.GHOSTWHITE);
				temp.spane.getChildren().add(cir);
				pane.getChildren().add(temp.spane);
				temp.circle.setStroke(Color.BLACK);
				temp.circle.setFill(Color.BLUEVIOLET);
			}
		}
		
		/**
		 * Returns shield collectible from saved game data.
		 * @param pos Position of shield
		 * @param y Y coordinate of shield
		 * @param pane main game screen layout which adds components into it.
		 */
		public shield(ArrayList<Double> pos , int y , Pane pane)
		{
			for(int i=0 ; i<pos.size() ; i++)
			{
				point temp = new point(new centre(pos.get(i).intValue(),y),13);
				shields.add(temp);
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
			return shields.get(0).c.gety();
		}
		
		/**
		 * Moves shield downward
		 * @param y Y coordinate to which wall needs to be moved
		 * @param pane main game screen layout which adds components into it.
		 */
		public void translate(int y,Pane pane)
		{
			for(point temp : shields)
			{
				if(pane.getChildren().contains(temp.spane))
					temp.setc(new centre(temp.c.getx(),y));
			}
		}
	}
