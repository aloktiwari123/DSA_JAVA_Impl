package queue;

public class QueueLink<T extends Comparable<T>> {
	
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int size;
	
	public boolean isEmpty()
	{
		return this.firstNode==null;
	}
	public int size()
	{
		return this.size;
	}
	public void enqueue(T data)
	{
	    this.size++;
	    Node<T> oldnode=this.lastNode;
	    this.lastNode=new Node<T>(data);
	    this.lastNode.setNextnode(null);
	    if (isEmpty())
	    {
	    	this.firstNode=this.lastNode;
	    }
	    else
	    {
	    	oldnode.setNextnode(this.lastNode);
	    }
	}
	public T dqueue()
	{
		this.size--;
		T data=this.firstNode.getData();
		this.firstNode=this.firstNode.getNextnode();
		if(isEmpty())
		{
			this.lastNode=null;
		}
		return data;
	}

}
