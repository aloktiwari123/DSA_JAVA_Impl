package bst;

public class Node<T extends Comparable<T>> {
	private T data;
	private Node<T> leftchild;
	private Node<T> rightchild;
	
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

	public Node<T> getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(Node<T> leftchild) {
		this.leftchild = leftchild;
	}

	public Node<T> getRightchild() {
		return rightchild;
	}

	public void setRightchild(Node<T> rightchild) {
		this.rightchild = rightchild;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.data.toString();
	}
	

}
