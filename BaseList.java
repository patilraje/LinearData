
// BaseList.java
//
// This class is just a starting point for the four lists that will be used in this project. // Because the only thing that will differentiate them is the WAY we do the additions to the // list, we can put all of the code that's common to ALL of them here, and use inheritance // to build the four specific lists. We declare this one as being abstract simply to keep // from accidentally instantiating it -- it doesn't HAVE its add method.
//
// By forcing this layer of inheritance into the process, every list's class just consists // of a one-line constructor (to call this one), and its add() method.
public abstract class BaseList implements ListInterface
{
    LLNode head;
    long   refChanges;
    long   keyCompare;
    
    BaseList() // constructor: empty head, counters set to zero
    {
        head = null;
        refChanges = 0;
        keyCompare = 0;
    }
   
    
    
    
    @Override
    public long getRefChanges()
    {
    	// How many reference changes did we do (how much structural work)? //
    	return refChanges;
    }
    @Override
    public long getKeyCompare()
    {
    	// How many key comparisons (how much work was done looking for things on the head)? //
    	return keyCompare;
    }
    @Override
    public int getDistinctWords()
    {
    	// How many nodes are there on the head? Each corresponds to a unique word //
    	int count = 0;
        
        LLNode p = head;
       
        

        while (p != null)
        {
        	count++;
        	p = p.getNext(); 
        }
        	return count;
    }
    
    public int getTotalWords()  // How many TOTAL words? That's the sum of the counts in each node.
    {
    	int count = 0;
    	LLNode p = head;
    	while (p != null)
    	{	
    		count += p.getCount();
    		p = p.getNext();
    	}
    	return count;
    }
    
    public void display()
    {
    	
    	LLNode p = head;
    	for (int i=0; i<100; i++)  //runs and prints first 100 elements 
    	{
    		{	
    			System.out.println(p.getInfo() + " "+ p.getCount());  //getting the info and count for the first 100 words
    			p = p.getNext();  //traversing through the list
    		}
    	}	
    }
    
    public int getH()
	{
		int h = 0;
		return h;
	}
}