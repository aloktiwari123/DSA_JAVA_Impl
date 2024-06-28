package queue;

public class Node<T extends Comparable<T>>{
	private T data;
	private Node<T> nextnode;
	
	public Node(T data)
	{
		this.data=data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextnode() {
		return nextnode;
	}

	public void setNextnode(Node<T> nextnode) {
		this.nextnode = nextnode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data.toString();
	}

}
