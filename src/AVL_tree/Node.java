package AVL_tree;

public class Node<T extends Comparable<T>> {
	
	private T data;
	private Node<T> leftsubtree;
	private Node<T> rightsubtree;
	private int Height;
	
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
	public Node<T> getLeftsubtree() {
		return leftsubtree;
	}
	public void setLeftsubtree(Node<T> leftsubtree) {
		this.leftsubtree = leftsubtree;
	}
	public Node<T> getRightsubtree() {
		return rightsubtree;
	}
	public void setRightsubtree(Node<T> rightsubtree) {
		this.rightsubtree = rightsubtree;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}
}
