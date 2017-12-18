package v1;
import java.util.*;
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: [REDO] Complete and thoroughly tested
 * Last update: 02/17/2017
 * Submitted:  02/20/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 2017.02.17
 */
public class ListArrayListBasedPlus extends ListArrayListBased
{

	public void reverse ()
	{
		ArrayList<Object> reverse = new ArrayList<Object>();
		
		for (int c = o.size()-1; c >= 0; c--)
		{
			Object oR = o.get(c);
			reverse.add(oR);
		}
		
		o = reverse;
	}
	
	public String toString()
	{
		String s = "";
		for (int c = 0; c < o.size(); c++)
		{
			s += c + " " + o.get(c) + " ";
		}
		return s;
	}
}
