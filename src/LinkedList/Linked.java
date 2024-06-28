package LinkedList;

public class Linked <T extends Comparable<T>>implements List<T>
{
	 private Node<T> root;//only root can be accessed for Linked list
     private int sizeOflist;//size  of the linked list
	
	public void insert(T data)//fun to insert the node 
	{
		// TODO Auto-generated method stub
		++this.sizeOflist;
		if(root==null)
		{
			this.root=new Node<T>(data);
		}
		else
		{
			insertdataatbegining(data);
		}
	}
	//O(1) complexity
	public void insertdataatbegining(T data)
	{
		Node<T> newnode=new Node<T>(data);//creating a new node with initializing the value data
		newnode.setNextnode(root);
		this.root=newnode;
		
	}
	//O(N) complexity
	public void insertdataattheend(T data,Node<T> node)
	{
		if(node.getNextnode() != null)
		{
			insertdataattheend(data,node.getNextnode());
		}
		else
		{
		Node<T> newnode=new Node<T>(data);//creating a new node with initializing the value data
		node.setNextnode(newnode);
		}
		
		
	}
	


	public void remove(T data) {
		// TODO Auto-generated method stub
	    if(this.root==null)return;
	    --this.sizeOflist;
	    if(this.root.getData().compareTo(data)==0)
	    {
	    	this.root=this.root.getNextnode();
	    }
	    else
	    {
	    	remove(data,this.root,this.root.getNextnode());
	    }
		
	}
	private void remove(T data,Node<T> previousnode,Node<T> currentnode)
	{
	  while(currentnode != null)
	  {
		  if(currentnode.getData().compareTo(data)==0)
          {
			  previousnode.setNextnode(currentnode.getNextnode());
			  currentnode=null;
			  return;
			  }
		  previousnode=currentnode;
		  currentnode=currentnode.getNextnode();

	  }
	}

	
	public int lenght() {
		// TODO Auto-generated method stub
		return this.sizeOflist;
	}

	
	public void traverse() 
	{
		// TODO Auto-generated method stub
		if(this.root==null)return;
		Node<T> actualnode=this.root;
		
		while(actualnode !=null)
		{
			System.out.print(actualnode+" -> ");
			actualnode=actualnode.getNextnode();
		}
		System.out.println();
		
	}
	

}
