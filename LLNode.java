
class LLNode
 {
	private String data;
	private LLNode link;
	int count;
 
	public LLNode(String s)
    { 
    	this.data = s;
    	count=1;
    	link=null;
    }
    public String getInfo()
    { 
    	return this.data; 
    }
    public void setNext(LLNode link)
    {
    	this.link = link;
    } 
    
    public LLNode getNext()
    {
    	return link;
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