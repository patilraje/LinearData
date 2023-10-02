
public class SLNode 
{
	
	    String data; // A comparable value we use to determine position
	    int value;  // auxiliary data associated with the key

	    public SLNode up, down, left, right; // all four links

	    // Rather than looking for a VALUE to ID a sentinel node, we 
	    // could just FLAG them as being sentinel nodes!
	    public boolean isSentinel = false;

	    public static final String NEG_INF = "negInf"; // these Strings
	    public static final String POS_INF = "posInf"; // into the list!
	    
	    //<constructors, getters, and setters>
	    
	    
	    //private String key;
		int count;
	 
		public SLNode(String s)  
	    { 
	    	this.data = s;
	    	count=1;
	    	up=null;
	    	down=null;
	    	left=null; 
	    	right=null;
	    }
		
		
	    public String getInfo()
	    { 
	    	return this.data; 
	    }
	    
	    
	    
	    //Link to upper node
	    public void setUp(SLNode up)
	    {
	    	this.up = up;
	    } 
	    
	    public SLNode getUp()
	    {
	    	return up;
	    }

	    
	    //Link to lower node
	    public void setDown(SLNode down)
	    {
	    	this.down = down;
	    } 
	    
	    public SLNode getDown()
	    {
	    	return down;
	    }
	    
	    
	    
	    //Link to the right node
	    public void setRight(SLNode right)
	    {
	    	this.right = right;
	    } 
	    
	    public SLNode getRight()
	    {
	    	return right;
	    }
	    
	    
	    
	    //Link to the left node
	    public void setLeft(SLNode left)
	    {
	    	this.left = left;
	    } 
	    
	    public SLNode getLeft()
	    {
	    	return left;
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
