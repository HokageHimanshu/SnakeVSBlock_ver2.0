package cp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


class s_block_wall implements Serializable
{
	private static final long serialVersionUID = 1L;
	ArrayList<Double> pos;
	ArrayList<String> color;
	ArrayList<String> value;
	int y;
	public s_block_wall(ArrayList<Double> pos,ArrayList<String> color,ArrayList<String> value,int y)
	{
		this.value = value;
		this.pos = pos;
		this.color = color;
		this.y = y;
	}
}

class s_ball  implements Serializable
{
	private static final long serialVersionUID = 3870219527087193833L;
	ArrayList<Integer> val;
	ArrayList<Double> pos;
	int y;
	public s_ball(ArrayList<Double> pos,ArrayList<Integer> val,int y)
	{
		this.val = val;
		this.pos = pos;
		this.y = y;
	}
}

class s_wall  implements Serializable
{
	private static final long serialVersionUID = -621441342296474424L;
	ArrayList<Double> pos;
	int y;
	public s_wall(ArrayList<Double> pos,int y)
	{
		this.pos = pos;
		this.y = y;
	}
}

class s_shield  implements Serializable
{
	private static final long serialVersionUID = 633119056168431086L;
	ArrayList<Double> pos;
	int y;
	public s_shield(ArrayList<Double> pos,int y)
	{
		this.pos = pos;
		this.y = y;
	}
}

class s_destroyer  implements Serializable
{
	private static final long serialVersionUID = 1856789606615032876L;
	ArrayList<Double> pos;
	int y;
	public s_destroyer(ArrayList<Double> pos,int y)
	{
		this.pos = pos;
		this.y = y;
	}
}

class s_magnet implements Serializable
{
	private static final long serialVersionUID = -839941206203026911L;
	ArrayList<Double> pos;
	int y;
	public s_magnet(ArrayList<Double> pos,int y)
	{
		this.pos = pos;
		this.y = y;
	}
}



/**
 * Responsible for state save of the current game
 * @author Himanshu and Kartikey
 *
 */
public class save_game  implements Serializable
{
	private static final long serialVersionUID = 3300261882835347146L;
	s_block_wall s_mblock_wall1;
	s_block_wall s_mblock_wall2;
	
	s_wall s_mdeevar1;
	s_wall s_mdeevar2;
	
	s_ball s_mball1;
	s_ball s_mball2;
	s_ball s_mball3;
	
	s_shield s_mbachao1;
	s_destroyer s_mdestroyer;
	s_magnet s_mkheecho;
	
	int saanp_length;
	int s_scoree;
	
	/**
	 * Saves state of individual components in file
	 * @param block_wall1 reference to wall of blocks 1
	 * @param block_wall2 reference to wall of blocks 2
	 * @param deevar1 wall reference to 1
	 * @param deevar2 wall reference to w
	 * @param ball1 reference to list of balls 1
	 * @param ball2 reference to list of balls 2
	 * @param ball3 reference to list of balls 3
	 * @param bachao1 reference to shield
	 * @param kheecho reference to magnet 
	 * @param destroyer reference to block destroyer
	 * @param saanp_length length of snake
	 * @param scoree current game score
	 */
	public save_game(block_wall block_wall1 , block_wall block_wall2 , wall deevar1 , wall deevar2 ,
			ball ball1 , ball ball2 , ball ball3 , shield bachao1 , magnet kheecho , destroy_blocks destroyer 
			, int saanp_length , int scoree)
	{
		this.s_mblock_wall1 = handle_block_wall(block_wall1);
		this.s_mblock_wall2 = handle_block_wall(block_wall2);
		this.s_mdeevar1 = handle_walls(deevar1);
		this.s_mdeevar2 = handle_walls(deevar2);
		this.s_mball1 = handle_balls(ball1);
		this.s_mball2 = handle_balls(ball2);
		this.s_mball3 = handle_balls(ball3);
		this.s_mkheecho = handle_magnets(kheecho);
		this.s_mbachao1 = handle_shields(bachao1);
		this.s_mdestroyer = handle_destroyer(destroyer);
		this.saanp_length = saanp_length;
		this.s_scoree = scoree;
		save();
	}
	
	/**
	 * Open up the output stream
	 */
	public void save()
	{
		ObjectOutputStream outt;
		try {
			outt = new ObjectOutputStream(new FileOutputStream("save"));
			outt.writeObject(this);
			outt.close();
		}
		catch(Exception a) {System.out.println(a);}
	}
	
	/**
	 * Convert state of block_walls into savable state
	 * @param wall block_wall instance
	 * @return savable block_wall instance
	 */
	public s_block_wall handle_block_wall(block_wall wall)
	{
		if(wall == null)
			return null;
		ArrayList<Double> pos = new ArrayList<Double>();
		ArrayList<String> color= new ArrayList<String>();
		ArrayList<String> val = new ArrayList<String>();
		int y = wall.getY();
		for(block temp : wall.wall)
		{
			pos.add(temp.pane.getLayoutX());
			color.add(temp.box.getFill().toString());
			val.add(temp.text.getText());
		}
		return new s_block_wall(pos,color,val,y); 
	}
	
	/**
	 * Convert state of wall into savable state
	 * @param deevar wall instance
	 * @return savable wall instance
	 */
	public s_wall handle_walls(wall deevar)
	{
		if(deevar == null)
			return null;
		ArrayList<Double> pos = new ArrayList<Double>();
		int y = deevar.getY();
		for(Rectangle temp : deevar.dande)
		{
			pos.add(temp.getLayoutX());
		}
		return new s_wall(pos,y);
	}
	
	/**
	 * Convert state of magnets into savable state
	 * @param kheecho magnet instance
	 * @return savable magnet instance
	 */
	public s_magnet handle_magnets(magnet kheecho)
	{
		if(kheecho == null)
			return null;
		ArrayList<Double> pos = new ArrayList<Double>();
		int y = kheecho.getY();
		for(point temp : kheecho.magnets)
		{
			pos.add(temp.spane.getLayoutX());
		}
		return new s_magnet(pos,y);
	}
	
	/**
	 * Convert state of destroyer into savable state
	 * @param destroyer destroy_block instance
	 * @return savable destroy_block instance
	 */
	public s_destroyer handle_destroyer(destroy_blocks destroyer)
	{
		if(destroyer == null)
			return null;
		ArrayList<Double> pos = new ArrayList<Double>();
		int y = destroyer.getY();
		for(point temp : destroyer.destroy_blocks)
		{
			pos.add(temp.spane.getLayoutX());
		}
		return new s_destroyer(pos,y);
	}
	
	/**
	 * Convert state of shield into savable state
	 * @param bachao shield instance
	 * @return savable shield instance
	 */
	public s_shield handle_shields(shield bachao)
	{
		if(bachao == null)
			return null;
		ArrayList<Double> pos = new ArrayList<Double>();
		int y = bachao.getY();
		for(point temp : bachao.shields)
		{
			pos.add(temp.spane.getLayoutX());
		}
		return new s_shield(pos,y);
	}
	
	/**
	 * Convert state of balls into savable state
	 * @param ball ball instance
	 * @return savable ball instance
	 */
	public s_ball handle_balls(ball ball)
	{
		if(ball == null)
			return null;
		ArrayList<Double> pos = new ArrayList<Double>();
		ArrayList<Integer> val = new ArrayList<Integer>();
		int y = ball.getY();
		for(point temp : ball.balls)
		{
			pos.add(temp.spane.getLayoutX());
		}
		for(Text temp : ball.text)
		{
			val.add(Integer.parseInt(temp.getText()));
		}
		return new s_ball(pos,val,y);
	}

}