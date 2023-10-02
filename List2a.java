
public class List2a extends BaseList
{
	LLNode temp;
	LLNode newNode;
	LLNode previous;
	LLNode previousnewNode;

		@Override
		public void add(String word) 
		{
			
			if(head==null)      //list is empty
			{
				head = new LLNode(word);
				head.setNext(null); 	//inserting the first node
				previousnewNode=head;
				refChanges+=2; 
				return;
			}
			
			 
			temp=head;
			previous=null;
		    
			keyCompare++;
			if(word.compareTo(previousnewNode.getInfo())== 0)
			{
				previousnewNode.increment();
				return;
			}
			
			keyCompare++;
			if(word.compareTo(previousnewNode.getInfo())> 0 && previousnewNode.getNext()!=null)  //if the new node added is in between nodes in the list 
																					//get next will not be null, however if it is null 
																					//it means it is the last node and that case is handled under this if statement
			{
				temp=previousnewNode.getNext();
				previous=previousnewNode;
			}
			
			else if(word.compareTo(previousnewNode.getInfo())> 0 && previousnewNode.getNext()==null)  //if the word that was recently added
				//is the last node then we just add a node after it and exit the method
				//this if statement saves exactly 0.21 seconds on my laptop compared to sorted list 2

			{
				newNode= new LLNode(word);
				newNode.setNext(null);
				previousnewNode.setNext(newNode);
				previousnewNode=newNode;
				refChanges+=2;
				return;
			}
			
			
			
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
									
					if(previous == null)
					{
						newNode.setNext(temp);  //add the word before that
						head=newNode;
						previousnewNode=temp;
						refChanges+=2;
						return;
					}
					
					else 
					{
						newNode.setNext(temp);  //add the word before that
						previous.setNext(newNode);			//set the link of previous node to the node next to temp
						previousnewNode=newNode;
						refChanges+=2;
						return;
					}
					
				}
		    
		    else 
		    	{
		    	
		    	newNode= new LLNode(word);
		    	newNode.setNext(null);
		    	temp.setNext(newNode);
		    	previousnewNode=newNode;
		    	refChanges+=2;
		    	
		    	}
		}
}
