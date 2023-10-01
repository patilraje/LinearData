public class BinaryTree extends BaseList
{
	String s;
	int numElements = 0;
	int n=0;  //total words
	BSTNode root;
	BSTNode temp;
	BSTNode min;
	BSTNode successor;
	 
	
	public void add(String word)    
	{
		
		s=word;
		
		/* If the tree is empty, return a new Node */
        if (root == null)
        {
        	BSTNode newNode = new BSTNode(s);
	   		root=newNode;
	   		numElements++; // distinct words
	   		n++; // total words
	   		refChanges+=2;
	   		return;
        }
        
  
        temp=search(root,s);
        
        keyCompare++;
        
        if(s.compareTo(temp.getInfo())>0)
        {
        	BSTNode newNode = new BSTNode(s);
	   		temp.setRight(newNode);
	   		newNode.setParent(temp);
	   		numElements++; // distinct words
	   		n++; // total words
	   		refChanges+=2;
	   		return;
        }
        	
        else if(s.compareTo(temp.getInfo())<0)
        {
        	BSTNode newNode = new BSTNode(s);
	   		temp.setLeft(newNode);
	   		newNode.setParent(temp);
	   		numElements++; // distinct words
	   		n++; // total words
	   		refChanges+=2;
	   		return;
        }
        
        else
        {
        	temp.increment();
        	n++;
        	return;
        }
       
	}
	
	public BSTNode search(BSTNode temp, String s)
	{
		 while (temp != null) 
	      {
	        // pass right subtree as new tree
	        if ((s.compareTo(temp.getInfo())>0) && temp.getRight()!=null)
	        { 
	        	keyCompare++;
	        	temp = temp.getRight(); 
	        }
	 
	        // pass left subtree as new tree
	        else if ((s.compareTo(temp.getInfo())<0) && temp.getLeft()!=null)
	        { 
	        	keyCompare++;
	        	temp = temp.getLeft(); 
	        }
	        
	        else 
	        { return temp; }
	        
	      }
		  return temp;
	}
        
            
       
    // new BST Node
     public BSTNode newNode(String s)
    {
    	 BSTNode newNode = new BSTNode(s);
		 temp=newNode;
		 numElements++; // distinct words
		 n++; // total words
		 refChanges+=2;
		 return temp;
    }
 
  
  
 
	
	public int getDistinctWords()
	{
		return numElements;
	}
	
	public int getTotalWords()
	{
		 return n;
	}

	
	
	//returns the min value
	public BSTNode min(BSTNode temp)
	{
		while(temp.getLeft()!=null)
		{
			temp=temp.getLeft();
		}
		return temp;
	}
	
	//returns the max value
	public BSTNode max()
	{
		while(temp.getRight()!=null)
		{
			temp=temp.getRight();
		}
		return temp;
	}
	
	public BSTNode successor(BSTNode a)
	{
		if(a.getRight()!=null)
		{
			return min(a.getRight());
		}
		
		BSTNode b=a.getParent();
		while(b!=null && a==b.getRight())
		{
			a=b;
			b=b.getParent();
		}
		
		return b;
	}
			
	public void display()
	{
		BSTNode min= min(root);
		
		int d=getDistinctWords();
		if(d>=100)
		{
			
			for(int i=0; i<=100; i++)
			{
				System.out.println(min.getInfo() + " : " + min.getCount());
				min=successor(min);
			}
		}
		
		else
		{
			for(int i=0; i<d; i++)
			{
				System.out.println(min.getInfo() + " : " + min.getCount());
				min=successor(min);
			}
		}

		
	}
	
	int height(BSTNode node)
    {
        if (node == null)
            return 0;
        else 
        {
            /* compute the depth of each subtree */
            int lDepth = height(node.getLeft());
            int rDepth = height(node.getRight());
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
	
	public int getH()
	{
		
		int h= height(root);
		return h;
		
	}

}
