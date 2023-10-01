import java.util.Random;

public class List5 extends BaseList {

	private SLNode heads, tail; // head and tail pointers
	private int h; // height (# of lanes)
	private int n; // # Items in list in the slower lane
	private Random r; // we’re about to discuss this

	public List5() // constructor
	{
		heads = new SLNode(SLNode.NEG_INF); // create the two
		tail = new SLNode(SLNode.POS_INF); // sentinel nodes
		heads.right = tail; // link them to ...
		tail.left = heads; // ... each other
		r = new Random(); // create a RNG (to use later)
		n = 0; // no entries yet (empty list)
		h = 1; // no new levels yet (still single level)
		heads.up = null; //creating a new node without any linkage to any other 
		heads.left = null;
		heads.down = null;
		tail.right = null;
		tail.up = null;
		tail.down = null;

	}

	/* The addNew method is a recursive one, we add a new word when required and then
	 * we flip a coin using the random class to determine if we need to add the node 
	 * to the faster lane.
	 */
	private SLNode addNew(SLNode temp, String word) 
	{
		refChanges+=6;   
		SLNode newNode = new SLNode(word); //creating a new node and adding it in the slower lane
		newNode.up = null;
		newNode.down = null;
		newNode.left = temp;
		newNode.right = temp.right;
		temp.right.left = newNode;
		temp.right = newNode;

		float val = r.nextFloat();

		if (val <= 0.5) // for faster lane 
		{
			//traversing until we find a link to the faster lane
			while (temp.up == null && temp.left != null) 
			{
				//keep moving towards the left i.e negative infinity
				temp = temp.left;
			}

			if (temp.up != null) 
			{
				//once we find the link to faster lane, add the new node there
				
				 /* calls for recursive method, which again creates a new node and if 
				    random generates heads we add a node in the lane above the faster 
				    lane and so on */
				 
				SLNode topNode = addNew(temp.up, word); //recursive
				topNode.down = newNode; //once the method returns the node we link it
				newNode.up = topNode;	//to the node in the slower lanes
			}

			else // we reached negative infinity which means a faster lane does not exist
			{
				
				refChanges+=6;
				//therefore we create a new fast lane here
				
				SLNode head2 = new SLNode(SLNode.NEG_INF); // create the two
				SLNode tail2 = new SLNode(SLNode.POS_INF); // sentinel nodes
				head2.right = tail2; // link them to ...
				tail2.left = head2; // ... each other

				head2.up = null;
				head2.left = null;
				head2.down = heads;
				heads.up = head2;
				heads = head2;

				tail2.right = null;
				tail2.up = null;
				tail2.down = tail;
				tail.up = tail2;
				tail = tail2;

				h++; //the height increases since we are creating a faster lane

				SLNode topNode = addNew(heads, word);//recursive
				//after creating the new lane we add the node in this lane
				topNode.down = newNode;
				newNode.up = topNode;
			}
		}
		return newNode;
	}

	/* the traverse lane method traverses through the list starting from the fastest 
	   lane and then proceeding to the slower lanes. depending on the value of the words
	   we move towards the right or left. this is also  a recursive method */
	
	private void traverseLane(SLNode temp, String word) 
	{

		if (temp.left == null)  //checking if it is negative infinity
		{
			keyCompare++;
			if (word.compareTo(temp.right.getInfo()) < 0) //if the word is less than the first node
			{
				if (temp.down == null) //and if it is in the slowest lane
				{
					addNew(temp, word); //recursive
					//add the word
					n++;
					return;
				} 
				else 
				{
					traverseLane(temp.down, word); //recursive
					//otherwise get the reference to the
					//slower lane and the traverse again
					return;
				}
			}

			if (word.compareTo(temp.right.getInfo()) == 0)  //if the word is found
			{
				temp = temp.right; //we store the reference in temp

				while (temp.down != null) //if it is not in the slowest lane
										//we keep moving down until we reach the slowest lane
				{
					temp = temp.down;  

				}

				temp.increment(); //once we've reached the slowest lane we increment the count and leave the method
				return;
			}

			traverseLane(temp.right, word);  //recursive
			//if it is greater than the node, we move towards the right and traverse again
			return;
		}


		// Continue to traverse through the current row until current word is greater
		// than temp or we reach positive infinity
		
		keyCompare++;
		while (temp.right != null) // traversing
		{
			
			if (word.compareTo(temp.getInfo()) <= 0) //Need to insert before or increase the count
			{
				break;
			}

			temp = temp.right;
		
		}

		// If the traversal is interrupted because we found the match, then we go to the
		// bottom lane and increment the count
		
		keyCompare++;
		if (word.compareTo(temp.getInfo()) == 0) 
		{
		
			while (temp.down != null) 
			{
				temp = temp.down;

			}

			temp.increment();
			return;
		}


		if (temp.down == null) 
		{
			addNew(temp.left, word); //recursive
			n++;
			return;
		}

		traverseLane(temp.left.down, word); // recursive
		return;
	}

	public SLNode search(String k) 
	{ // returns a slow-lane pointer to either the node containing key k
										// or the slow-lane node preceding where k WOULD be if in the list
		SLNode p = heads;
		while (true)
		{
			while (SLNode.POS_INF.compareTo(p.right.data) != 0 && p.right.data.compareTo(k) <= 0)
				p = p.right;
			if (p.down == null)
				return p;
			p = p.down;
		}
	}

	@Override
	public void add(String word) 
	{

		if (heads.right == tail) 
		{
			addNew(heads, word);
			n++;
		} 
		else 
		{
			traverseLane(heads.right, word);
		}
	}

	@Override
	public long getRefChanges() {
		// How many reference changes did we do (how much structural work)? //
		return refChanges;
	}

	@Override
	public long getKeyCompare() {
		// How many key comparisons (how much work was done looking for things on the
		// head)? //
		return keyCompare;
	}

	@Override
	public int getDistinctWords() {
		int a = 0;
		SLNode p = heads;

		while (p.down != null) {
			p = p.down;
		}

		// System.out.printf("%s ", p.getInfo());
		p = p.right; // Skip the negative infinity
		// System.out.printf("%s ", p.getInfo());
		while (p.right != null) { // Stop at the positive infinity
			a++;
			p = p.right;
			// System.out.printf("%s ", p.getInfo());
		}

		// System.out.printf(" = %d\n", a);
		return a;
	}

	public int getTotalWords() // How many TOTAL words? That's the sum of the counts in each node.
	{
		int a = 0;
		SLNode p = heads;

		while (p.down != null) {
			p = p.down;
		}

		// System.out.printf("%s(%d) ", p.getInfo(), p.getCount());
		p = p.right; // Skip the negative infinity
		// System.out.printf("%s(%d) ", p.getInfo(), p.getCount());
		while (p.right != null) { // Stop at the positive infinity
			a += p.getCount();
			p = p.right;
			// System.out.printf("%s(%d) ", p.getInfo(), p.getCount());
		}

		// System.out.printf(" = %d\n", a);
		return a;
	}

	public void display() 
	{
		SLNode p = heads;
		for (int i = 0; i < 100; i++) // runs and prints first 100 elements
		{

			{
				System.out.println(p.getInfo() + " " + p.getCount()); // getting the info and count for the first 100
																		// words
				p = p.getRight(); // traversing through the list
			}
		}
	}
	
	public int getH()
	{
		return h;
	}
}

