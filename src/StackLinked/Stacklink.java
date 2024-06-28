package StackLinked;

public class Stacklink<T extends Comparable<T>> {
	
	private int size;
	private Node<T> root;
	
	public void push(T data)
	{
		++ this.size;
		if(this.root==null)
		{
			this.root=new Node<T>(data);
		}
		else
		{
			Node<T> oldnode=this.root;//temporary variable to store the root
			this.root=new Node<T>(data);//assigning root to new node
			this.root.setNextnode(oldnode);//shifting previous root to lower position
		}
	}
	
	public T pop()
	{
		T itemTopop=this.root.getData();
		this.root=this.root.getNextnode();
		this.size--;
		return itemTopop;
	}
	public T peek()
	{
		return this.root.getData();
	}
	
	public int length()
	{
		return this.size;
	}
	
	public boolean isempty()
	{
		if(this.root==null)return true;
		return false;
	}
	
	
	

}
