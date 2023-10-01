
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Lab4
{

	public static void main(String args[])
	{
		String words = null;
		

		ListInterface[] Lists = new ListInterface[10]; // By creating the lists as an array,
		// we can iterate with a subscript
		Lists[0] = new List1(); // Unsorted, insertions at beginning, no self-optimization
		Lists[1] = new List2(); // Sorted linked list
		Lists[2] = new List2a(); // Unsorted, heavy-handed self-adjusting (moves repeated
		// word to the front of the list)
		Lists[3] = new List3(); // Unsorted, conservative self-adjusting (moves repeated
		// word one position towards front of list)
		Lists[4] = new List4();
		Lists[5] = new List5();
		Lists[6] = new Hash1();
		Lists[7] = new Hash2();
		Lists[8] = new Hash3();
		Lists[9] = new BinaryTree();
		
		
	
		
		String[] ListNames = {"Unsorted", "Sorted", "Sorted Modified", "Self-Adj (Front)", "Self-Adj (By One)", "Skip List", "Hash1", "Hash2", "Hash3", "BST"};
		
		//File file = new File("/Users/apple/Downloads/Hamlet.txt");
		Scanner sc = null;
		BufferedReader br = null;

		String punctuation = "!@#$%^&*()_+-=[]\\{}|;':\"`~,./<>?";

		System.out.printf("%-3s %-17s %-12s %-12s %-13s %-12s %-12s %-4s %n","#", "List Name ", "Run Time ", "Vocabulary ", "Total Words ", "Key Comp ", "Ref Chngs", "h");
		System.out.printf("%-3s %-17s %-12s %-12s %-13s %-12s %-12s %-4s %n","---","------------", "------------", "------------", "------------", "------------", "------------", "-----");
		
		for (int i = 0; i < 12; i++) 
		{
			long time; // What time did we start this test?
			double elapsed; // What was the elapsed time for all repetitions of this test (in seconds)?

			try 
			{
				br = new BufferedReader(new FileReader(args[0]));	
				sc = new Scanner(br);

			} catch (FileNotFoundException e)

			{
				e.printStackTrace();
			}
			
			
			if (i > 1) 
				
			{
				time = System.nanoTime(); // mark the start time
				while (sc.hasNext()) 
				{
			
					String letter = sc.next();
					words = letter.toLowerCase();
					

					{
					char first = words.charAt(0);
					while(punctuation.contains(String.valueOf(first)))
					{
						words = words.substring(1);
					    
						
						
						if (words != "")
						{
							first = words.charAt(0);
						}
						else 
						{
							break;
						}
						
					}
					
					char last = 'a';
					if (words != "")
					{
						 last = words.charAt(words.length()- 1);
					}
					while(punctuation.contains(String.valueOf(last)))
					{
						words = words.substring(0,words.length() - 1);
			
						if(words=="")
						{
							break;
						}
						
						else
						{
							last =  words.charAt(words.length()- 1);
						}
					}
					
					if(words!="")
					{
					Lists[i-2].add(words);
					}
				
				 }
				 
				}
				elapsed = ((System.nanoTime() - time) / 1000000000.0);
				System.out.printf("%-3s %-17s %-12s %-12s %-13s %-12s %-12s %-4s %n",i-1,ListNames[i-2] , elapsed, Lists[i-2].getDistinctWords(), Lists[i-2].getTotalWords() , Lists[i-2].getKeyCompare(), Lists[i-2].getRefChanges(),  Lists[i-2].getH() );
				
			}
		
		}
		  Lists[9].display();
	}
}
