/*
 * This list requires us to add words and every time the word is 
 * incremented, we move the word up by ONE node.  Now we have a reference 
 * to the two previous nodes of the current node(the node that we are comparing 
 * the word with) and the current node. It is easy to understand, just a little 
 * tricky to implement. It has two possibilities, we find the word or we do not. 
 * If we find the word in the list, we increment it by one and push it forward by 
 * one, we do this by setting the previous previous’  link to this current node, 
 * and the previous node gets linked to the node next to the current node, 
 * therefore removing it from its current position and putting it one node up. 
 * If we do not find the word in the list, we just make a new node, set it’s 
 * link to the head and make the word our new head and set the count to 
 * one(which our LLNode class implicitly does).
 */
public class List4 extends BaseList
{
	LLNode temp;
	LLNode temp2;
	LLNode previous;
	LLNode newNode;

	public void add(String word) 
	{
		if (head == null) // list is empty
		{
			head = new LLNode(word);
			head.setNext(null);
			refChanges+=2;
			return;
		}

		
		keyCompare++;
		if (word.compareTo(head.getInfo()) == 0) 
		{
			head.increment();
			return;
		}
		
		if (head.getNext() == null)
		{
			newNode = new LLNode(word);
			newNode.setNext(null);
			head.setNext(newNode);
			refChanges+=2;
			return;
		}

		temp2 = null;
		temp = head.getNext();
		previous = head;
		
		while ((word.compareTo(temp.getInfo()) != 0) && (temp.getNext() != null)) // traversing through the list for as
																					// long as the
		// word is not in the list or until we have
		// reached the last node
		{
			temp2 = previous;
			previous = temp;
			temp = temp.getNext();
			keyCompare++;
		}
		
		keyCompare++;
		if (word.compareTo(temp.getInfo()) == 0) // if we find the word
		{
			temp.increment(); // incrementing the count
			
			// to up to by one/push it forward by one
			if (temp2 == null) 
			{
				previous.setNext(temp.getNext());
				temp.setNext(previous);
				head=temp;
				refChanges+=3;
				return;
			} 
			else
			{
				previous.setNext(temp.getNext());
				temp.setNext(previous);
				temp2.setNext(temp);
				refChanges+=3;
			}
			return;
		} 
		else 
		{
			newNode = new LLNode(word);
			newNode.setNext(head);
			head = newNode;
			refChanges+=2;
			return;
		}
	}
}