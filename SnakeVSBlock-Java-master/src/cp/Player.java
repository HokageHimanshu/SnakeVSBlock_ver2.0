package cp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * This class maintains the record of the scores of the player. 
 * @author Himanshu and Kartikey
 *
 */
public class Player implements Serializable  {
	
	private ArrayList<Scoredata> playas;
	//private String file ;
	
	/**
	 * Initialises the list of Scoredata of the player. It checks whether a list a present in the file, 
	 * if it is present then that list is used.
	 */
	public Player()
	{
		playas = new ArrayList<Scoredata>();
		try {
		
		File f = new File("score.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream fiso = new ObjectInputStream(fis);
		Player p = (Player) fiso.readObject();
		
		System.out.println("object is read =" + p);
		
		if(fiso==null)
		{
			playas = new ArrayList<Scoredata>();
		}
		else
		{
			playas = p.getList();
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	
	/**
	 * Adds and udpates the new score in the list of the player
	 * @param tempscore is the new score to be inserted in the record of the player.
	 */
	public void updatescore(int tempscore)
	{
		Scoredata newentry =  new Scoredata(tempscore);
		if(playas.size()==0)
		{
			playas.add(newentry);
		}
		else
		{
			for(int i=0;i< playas.size();i++)
			{
				if(newentry.getScore() > (playas.get(i)).getScore())
				{
					playas.add(i,newentry);
					return;
				}				
			}
		}		
	}
	/**
	 * Mainntains the list size to upmost 10 entries.
	 */
	public void checksize()
	{
		if(playas.size()>=10)
		{
			for(int i=playas.size()-1;i>9;i--)
			{
				playas.remove(i);
				
			}
		}
	}
	
	/**
	 * Sorts the list of Scoredata
	 */
	public void sortlist()
	{
		Collections.sort(playas);
	}
	
	/**
	 * 
	 * @return the data present in the list in a particular formated way.
	 */
	public String getString()
	{
		String ans = "";
		int rank =0;
		for(int i=0;i<playas.size();i++)
		{
			rank = i+1;
			ans =ans+ " "+rank +")"+"     "+playas.get(i).getDate()+"      "+playas.get(i).getScore()+"\n";
		}
		return ans;
	}
	
	/**
	 * 
	 * @return the hightest score (int value) present in the list, otherwise it returns 0. 
	 */
	public int getHighestScore()
	{
		if(playas.size()==0)
		{
			return 0;
		}
		else
		{
			return playas.get(0).getScore();
		}
	}
	
	/**
	 * 
	 * @return the list of Scoredata of the player
	 */
	public ArrayList<Scoredata> getList()
	{
		return playas;
	}
	
	/**
	 * Saves the player object in the file specified.
	 */
	public void savetofile()
	{
		try
		{
		File f = new File("score.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream foso = new ObjectOutputStream(fos);
		foso.writeObject(this);
		
		System.out.println("Saved to file");
		
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	

}
