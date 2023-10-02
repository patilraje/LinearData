
public class Hash1 extends BaseList
{

	String s;
	LLNode[] map= new LLNode[256]; //creating an array of 256 
	int location = 0; //location set to 0 
	int numElements = 0;
	int n=0;
	LLNode temp;
	LLNode previous;
	LLNode newNode;
	

	@Override
	public void add(String word) 
	{
		s = word;
		location=getKey(s);
		
		//LLNode head = map[location];
		
		if (map[location] == null) // list is empty
		{
			map[location] = new LLNode(word);
			map[location].setNext(null);
			refChanges+=2;
			numElements++;
			n++;
			return;
		}

		
		if (word.compareTo(map[location].getInfo()) == 0) 
		{
			map[location].increment();
			keyCompare++;
			n++;
			return;

		}

		temp = map[location];
		previous = map[location];

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
			n++;
			previous.setNext(temp.getNext());
			temp.setNext(map[location]);
			map[location] = temp;
			refChanges+=3;
			return;
		}
		else 
		{
			newNode = new LLNode(word);
			newNode.setNext(map[location]);
			map[location] = newNode;
			numElements++;
			n++;
			refChanges+=2;
		}
	}
		 

	public int getKey(String s)
	{
		int length = s.length();  //length of the word
		int value=0;
		int key=0;
		
		while(length!=0)
		{
			char ch= s.charAt(length-1);
			value+=(int)ch;
			s=s.substring(0, length);
			length--;
		}
		
		key=Math.abs(value%256); //%256
		return key;
	}
	
	public int getDistinctWords()
	{
		return numElements;
	}
	
	public int getTotalWords()
	{
		return n;
	}
	
	public void display()
	{
		
		for(int i=0;i<=255; i++)
		{
			int ctr=0;
			head=map[i];
			while(head!=null && head.getInfo()!=null)
			{
				ctr++;
				//System.out.println(i +" "+ head.getInfo());
				head=head.getNext();
			}
			System.out.println(ctr);
		}
	}
	
}
