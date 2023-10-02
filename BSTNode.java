
public class BSTNode 
{

	private String data;
	private BSTNode right;
	private BSTNode left;
	private BSTNode parent;
	int count;
 
	public BSTNode(String s)
    { 
    	this.data = s;
    	count=1;
    	right=null;
    	left=null;
    	parent=null;
    }
    public String getInfo()
    { 
    	return this.data; 
    }
    
  //setting link to the right node
    public void setRight(BSTNode right)
    {
    	this.right = right;
    } 
    
    //getting link to right node
    public BSTNode getRight()
    {
    	return right;
    }
    
    
    
    //setting link to the left node
    public void setLeft(BSTNode left)
    {
    	this.left = left;
    } 
    
    //getting link to left node
    public BSTNode getLeft()
    {
    	return left;
    }
   
  //setting link to the parent node
    public void setParent(BSTNode parent)
    {
    	this.parent = parent;
    } 
    
    //getting link to parent node
    public BSTNode getParent()
    {
    	return parent;
    }
    
	public void increment()
	{
		count++;
	}
	
	public int getCount()     //incrementing method
	{
		 return count;     
	}
	
}
