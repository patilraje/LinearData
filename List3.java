/*
 * This list does a lot of work in terms of moving a node around, 
 * this list requires adding the word at the top of the list every 
 * time we increment it. Now, this is how we do it, we have 3 references, 
 * the head node(Of course we do not want to lose the pointer to the head), 
 * the previous node, and the current node. Now we traverse through the list 
 * checking if the word is equal to any element in the list. Now there are 
 * two possibilities, it is not found or it is found. Now it is easy if it’s not 
 * found, we just make a new node and set it to head, then make that the head 
 * of our list. Whereas, if the word is FOUND, we increment it, remove it 
 * from the list and add it to the top of our list; here we don’t want to 
 * lose our list and this is where the previous comes into play, we set the 
 * link of the previous node to the node next to the current node, therefore 
 * completing one whole cycle of adding a word.
 */
public class List3 extends BaseList
{
	LLNode temp;
	LLNode previous;
	LLNode newNode;

	


	@Override
	public void add(String word) 
	{
		if (head == null) // list is empty
		{
			head = new LLNode(word);
			head.setNext(null);
			refChanges+=2;
			return;
		}

		
		if (word.compareTo(head.getInfo()) == 0) 
		{
			head.increment();
			keyCompare++;
			return;

		}

		temp = head;
		previous = head;

		while ((word.compareTo(temp.getInfo()) != 0) && (temp.getNext() != null)) // traversing through the list for as long as the
																		// word is not in the list or until we have
																		// reached the last node
		{
			previous = temp;
			temp = temp.getNext();
			keyCompare++;
		}

		keyCompare++;
		if (word.compareTo(temp.getInfo()) == 0) // if we find the word
		{
			temp.increment(); // incrementing the count
			previous.setNext(temp.getNext());
			temp.setNext(head);
			head = temp;
			refChanges+=3;
			return;
		}
		else 
		{
			newNode = new LLNode(word);
			newNode.setNext(head);
			head = newNode;
			refChanges+=2;
		}
	}
}
