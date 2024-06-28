package StackArray;

public class Stack<T> {
	private T[] stack;
	private int  size;
	
	public Stack()
	{
		this.stack=(T[]) new Object[1];
	}
	public void push(T data)
	{
		if(this.size==this.stack.length)
		{
			resize(2*this.stack.length);
		}
		this.stack[size++]=data;
	}
	public void resize(int l)
	{
		T[] stackcpy= (T[])new Object[l];
		for(int i=0;i<size;i++)
		{
			stackcpy[i]=this.stack[i];
		}
		this.stack=stackcpy;
	}
	public T pop()
	{
		T itempop=this.stack[--size];
		if(size>0 && size==this.stack.length/4)
		{
			resize(this.stack.length/2);
		}
		return itempop;
	}
	public boolean isempty()
	{
		return this.size==0;
	}
	public int size()
	{
		return this.size;
	}

}
