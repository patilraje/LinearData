/*
 * Here we had to keep track of the current node that we were
 * checking our word with and the node previous to that. The 
 * implementation is easy to understand, we traverse through the list 
 * for as long as the word we just received is greater than the words 
 * already in the list, IF the word happens to be smaller than the 
 * node we are checking with it has to go before that. Now we know 
 * for sure that this word is greater than the previous node and therefore 
 * it moved forward for comparisons. Now, since we have established that 
 * the word is less than the current node but greater than the previous node, 
 * we insert our new word between the previous node and the current node. 
 * And of course, if, while traversing through the list, we find that our 
 * word is equal to an element in the list, we just break out of the loop, 
 * increment it and move on. Another possibility could be that we do not find 
 * the word in the list, and it’s greater than every word in the list, if 
 * that’s the case then we make a new node and add it to the rear end of 
 * the list since it’s the largest alphabetically.
 */
public class List2 extends BaseList
{

	LLNode temp;
	LLNode newNode;
	LLNode previous;

	
	@Override
	public void add(String word) 
	{
		
		if(head==null)      //list is empty
		{
			head = new LLNode(word);
			head.setNext(null); 	//inserting the first node
			refChanges+=2; 
			return;
		}
		
		if(word.compareTo(head.getInfo())<0)
		{
			newNode= new LLNode(word);
			newNode.setNext(head);
			head=newNode;
			refChanges+=2;
			keyCompare++;
			return;
		}
        
		keyCompare++;
		if(word.compareTo(head.getInfo())==0)	//if the word in the head node matches the word
		{
			head.increment();        //we just increment since its already at the top of the list
			return;	
		}
		
		 if(head.getNext()==null)
		 {
			 newNode= new LLNode(word);
			 newNode.setNext(null);
			 head.setNext(newNode);
			 refChanges+=2;
			 return;
		 }
		 
		temp=head.getNext();
		previous=head;
	    
	    while((word.compareTo(temp.getInfo())> 0 && (temp.getNext()!=null)) ) //traversing through the list for as long as the word is not in the list or until we have reached the last node 
	    {
	    	
	    	previous=temp;
	    	temp=temp.getNext();
	    	keyCompare++;
	    }
	    	keyCompare++;
	    if(word.compareTo(temp.getInfo())==0)  				//if we find the word in the list, which should be already sorted, we just increment the count
	    {
	    	temp.increment();    				//incrementing the count
	    	return;
	    }
	    
		 
	    else if(word.compareTo(temp.getInfo())<0)  //if the word is smaller than temp node
			{
				newNode= new LLNode(word);
				newNode.setNext(temp);				//add the word before that
				previous.setNext(newNode);			//set the link of previous node to the node next to temp
				refChanges+=2;
				return;
			}
	    
	    else 
	    	{
	    	
	    	newNode= new LLNode(word);
	    	newNode.setNext(null);
	    	temp.setNext(newNode);
	    	refChanges+=2;
	    	
	    	}
	}
}
	    