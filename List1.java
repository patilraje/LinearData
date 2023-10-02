
/*
 * We add words to the list at the front, 
 * which means we always need a variable that points to 
 * the head(i.e. the first element of the list). Now, we 
 * set a loop that traverses through the list- it checks 
 * if the word already exists in the list, now this can go 
 * two ways, if the word already exists in the list, we break out of
 * the loop and increment the count on the word, if that doesn’t happen 
 * the other possibility is that we traverse through the list until we reach 
 * the end of it, and once we reach the end, we know that this word doesn’t
 * exist, then we make a new node with the word and count set to 1 and add 
 * it to the front of the list.
 */
public class List1 extends BaseList 
{
	LLNode temp;
	LLNode newNode;

	public void add(String word) 
	{

		temp = head; // assigning another variable to head
		while ( temp!= null) // traversing through the list until
																					// we reach the
		// end or find the word
		{
			keyCompare++; // the comparisons increase every time, since we are making a comparison 
			if (word.compareTo(temp.getInfo()) == 0) 
			{
				temp.increment();
				
				return;
			}
			temp = temp.getNext(); // we move onto the next node if the conditions are matched
			
		}
		
		 {
			newNode = new LLNode(word);
			newNode.setNext(head);
			head = newNode;
			refChanges+=2;
		}
	}

}
