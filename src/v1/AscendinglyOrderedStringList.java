package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 03/29/2017
 * Submitted:  03/30/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 03/29/2017
 */
public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface
{
	
	protected int numItems;
	protected final int SIZE = 3;
	protected String sA [] = new String [SIZE];
	

	public AscendinglyOrderedStringList()
	{
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}

	public int size()
	{
		return numItems;
	}

	private void resize()
	{
		String[] temp = new String[sA.length * 2];
		
		for(int c = 0; c < sA.length; c++)
		{
			temp[c] = sA[c];
		}
		
		sA = temp;
	}

	public void add(String item) throws ListIndexOutOfBoundsException
	{
		int index = 0;
		
		if(numItems != 0)
		{
			if((numItems + 1) >= sA.length)
			{
				resize();
			}	
			
			index = search(item);
			
			for(int c = numItems; c > index; c--)
			{
				sA[c] = sA[c-1];
			}
		}
		
		sA[index] = item;
		numItems++;	
	}

	
	public String get(int index) throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < numItems)
        {
            return sA[index];
        }
        else
        {
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on GET");
        }  
	}

	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < numItems)
		{
			for(int c = index + 1; c < numItems; c++)
			{
				sA[c - 1] = sA[c]; 
			}
			
			sA[numItems - 1] = null;
			numItems--;	
		}
		else

		{
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on REMOVE");
		}  
		
	}

	
	public int search(String item)
	{
		int low = 0;
		int high = numItems - 1;
		int mid = 0;
		int compare = 0;
		
			while(low <= high)
			{
				mid =  (low + high) / 2;
				compare = item.compareTo(sA[mid]);
				
				if(compare < 0)
				{
					high = mid - 1;
				}
				else if(compare > 0)
				{
					low = mid + 1;
				}
				else
				{
					low = Integer.MAX_VALUE;
				}				
			}
			
			if((mid == 0 && compare >= 1) || (mid == numItems-1 && compare >= 1))
			{
				mid++;
			}		
			
		return mid ;
	}

	public void clear()
	{
		sA = new String [SIZE];
		numItems = 0;
	}
	
	public String toString()
	{
		Object o;
		String s = "";
		
		for (int c = 0; c < numItems; c++)
		{
			o = sA [c];
			s +=  o + " " ;
			
		}
		return s;
	}
}
