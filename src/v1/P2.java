package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 03/29/2017
 * Submitted:  03/30/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 03/29/2017
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2
{
	static BufferedReader stdin = new BufferedReader ( new  InputStreamReader (System.in));
	static ListArrayListBasedPlus lalbp = new ListArrayListBasedPlus();
	public static void main(String[] args) throws IOException
	{
			int i;
			
			lalbp.add(0, 4);
			lalbp.add(1, 9);
			lalbp.add(2, 15);

			do
			{
				System.out.println("\n"+"Application's Options: ");
				System.out.println("                       ");
				System.out.println("1. Insert item into ordered list");
				System.out.println("2. Remove item from list");
				System.out.println("3. Get item from list");
				System.out.println("4. Search for a specific item in the list");
				System.out.println("5. Clear list");
				System.out.println("6. Print size and content of list");
				System.out.println("7. Exit Program");
				System.out.println("                       ");
				System.out.println("Choose your option: " + "\n");
				String input = stdin.readLine().trim();
				i = Integer.parseInt(input);
				
				if (i > 0 && i < 7)
				{
					switch(i)
					{
						case 1:
							// Use modified sequential search 2 [ eager advancing ]
							
							System.out.println("You are now inserting an item into the list.");
							System.out.println("Enter a value:");
							String value = stdin.readLine().trim();
							Integer sk = Integer.parseInt(value);
							// get first key for initial equality test
							Integer ck = (Integer)lalbp.get(0);
							boolean isAdded = false;
							search(sk);
							
						break;
						case 2:
							System.out.println("Select the index of an item you want to remove: ");
							String c2 = stdin.readLine().trim();
							Integer sk2  = Integer.parseInt(c2);
							
							if(sk2 >= 0 && sk2 <= lalbp.size() - 1)
							{
								Object ck2 = lalbp.get(sk2);
								lalbp.remove(sk2);
								
								System.out.println("Item " + ck2 + " is removed from index " + sk2);
							}
							else
							{
								System.out.println(sk2 + " is out of range.");
							}
							break;
						case 3:
							System.out.println("Select the index of an item you want to get: ");
							String c3 = stdin.readLine().trim();
							Integer sk3  = Integer.parseInt(c3);
							
							if(sk3 > lalbp.size()  - 1 || sk3 < 0)
							{
								System.out.println(sk3 + " is out of range. ");
							}
							else
							{
								Object ck3 = lalbp.get(sk3);
								
								System.out.println("Item " + sk3 + " is found from index " + sk3);
							}
							break;
						case 4:
							System.out.println("Enter a the index of an item you want to search: ");
							String c4 = stdin.readLine().trim();
							Object sk4 = Integer.parseInt(c4);
							Object ck4;
							boolean isHere = false;
							
							for (int c = 0; c < lalbp.size() && isHere == false; c++)
							{
								ck4 = lalbp.get(c);
								
								if(sk4.equals(ck4))
								{
									System.out.println("Item is found at: " + c);
									isHere = true;
								}
							}
							
							if(isHere == false)
							{
								System.out.println("Item is not exist in the list.");
							}
							break;
						case 5:
							lalbp.removeAll();
							System.out.println("List has been cleared");
							break;
						case 6:
							if(lalbp.isEmpty())
							{	
								System.out.println("List is empty");
							}
							else
							{
								System.out.println("Your list has: " + lalbp.size() +" item(s)");
								System.out.println(lalbp);
							}
							break;
					}
				}
				else if ( i == 7)
				{
					System.out.println("You are now exited the application");
					break;
				}
				else 
				{
					System.out.println("No such option exists for " + i );
				}
			}while(i < 7 || i > 7);
		}
	
	private static void search(Integer sk)
	{
		Integer ck = (Integer)lalbp.get(0);
		boolean isAdded = false;
		
		try
		{
			for (int c = 1; c < lalbp.size() + 1  && isAdded == false; c++)
			{
				// Advance if true
				if (sk > ck)
				{
					ck = ((Integer) lalbp.get(c));
				}
				//  Add if true
				else if (sk <= ck)
				{
					lalbp.add(c - 1, sk);
					isAdded = true;
				}
			}
		}
		// Add the sk to last index if we reach max index
		catch(ListIndexOutOfBoundsException e)
		{
			lalbp.add(lalbp.size(), sk);
		}
	}
}



