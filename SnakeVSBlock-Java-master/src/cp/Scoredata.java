package cp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Comparable;

/**
 * This class maintain a int score value and a date (String).
 * @author Himanshu and Kartikey
 *
 */
public class Scoredata implements Serializable , Comparable {
	
	private int score;
	private String date;
	
	/**
	 * Sets the date format and initialise the score attribute as the parameter passed.
	 * @param sc is the new score value 
	 */
	public Scoredata(int sc)
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		date = simpleDateFormat.format(new Date());
		//System.out.println(dates);
	
		score = sc;
	}
	
	/**
	 * 
	 * @return the stored Score value
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * 
	 * @return the stored date
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * Overriden function that instructs the sort function on how to compare different objects of this class.
	 */
	@Override
	public int compareTo(Object obj2) {
		// TODO Auto-generated method stub
		 int comparescore=((Scoredata)obj2).getScore();
	        /* For Descending order*/
	     return comparescore-this.score;
	}

}
