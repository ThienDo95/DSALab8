package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3
{

static BufferedReader stdin = new BufferedReader ( new  InputStreamReader (System.in));
	
	public static void main(String[] args) throws IOException
	{
			int i;
			AscendinglyOrderedStringList  as = new AscendinglyOrderedStringList();
			
			do
			{
				System.out.println("\n"+"Application's Options: ");
				System.out.println("                       ");
				System.out.println("1. Insert item to list");
				System.out.println("2. Remove item in specified position in the list");
				System.out.println("3. Search for a specific item in the list");
				System.out.println("4. Clear list");
				System.out.println("5. Print size and content of list");
				System.out.println("6. Exit Program");
				System.out.println("                       ");
				System.out.println("Choose your option: " + "\n");
				String input = stdin.readLine().trim();
				i = Integer.parseInt(input);
				
				if (i > 0 && i < 7)
				{
					switch(i)
					{
						case 1:
							System.out.println("You are now inserting an item into the list.");
							System.out.println("Enter item:");
							String item = stdin.readLine().trim();
							
							as.add(item);
						break;
						case 2:
							System.out.println("Select the index of an item you want to remove: ");
							String c2 = stdin.readLine().trim();
							Integer p2  = Integer.parseInt(c2);
							
							as.remove(p2);
							break;
						case 3:
							System.out.println("Enter a the index of an item you want to search: ");
							String c3 = stdin.readLine().trim();
							int sk = as.search(c3);
							
							if(Arrays.asList(as.sA).contains(sk))
							{
								System.out.println(c3 + " is found at " + sk);
							}
							else
							{
								System.out.println(c3 + " is inserted at " + sk + " to main lex order");
							}
							break;
						case 4:
							as.clear();
							System.out.println("List has been cleared");
							break;
						case 5:
							if(as.isEmpty())
							{	
								System.out.println("List is empty");
							}
							else
							{
								System.out.println("Your list has: " + as.size() +" item(s)");
								System.out.println(as.toString());
							}
							break;
					}
				}
				else if ( i == 6)
				{
					System.out.println("You are now exited the application");
					break;
				}
				else 
				{
					System.out.println("No such option exists for " + i );
				}
			}while(i < 6 || i > 6);
		}
}