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
public class ListArrayListBased implements ListInterface
{
	protected ArrayList<Object> o;
	
	public ListArrayListBased()
	{
		o = new ArrayList<Object>();
	}

	
	public boolean isEmpty()
	{
		return o.size()==0;
	}

	
	public int size()
	{
		return o.size();
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException
	{
		o.add(index, item);
	}

	public Object get(int index) throws ListIndexOutOfBoundsException 
	{
			return o.get(index);	
	}

	
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		o.remove(index);
	}

	public void removeAll()
	{
		 o = new ArrayList<Object>();	
	}
	
}
