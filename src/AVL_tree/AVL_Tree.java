package AVL_tree;

public class AVL_Tree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub
		root=insertData(root,data);
		
	}

	private Node<T> insertData(Node<T> node, T data) {
		// TODO Auto-generated method stub
		if(node==null) 
			{
			return new Node<T>(data);
			}
		if(data.compareTo(node.getData())<0)
		{
			node.setLeftsubtree(insertData(node.getLeftsubtree(), data));
		}
		else
		{
			node.setRightsubtree(insertData(node.getRightsubtree(), data));
		}
		node.setHeight(Math.max(height(node.getLeftsubtree()),height(node.getRightsubtree()))+1);
		return settleinsertViolation(data,node);
		
	}

	private Node<T> settleinsertViolation(T data, Node<T> node) {
		// TODO Auto-generated method stub
		
		int balance=getBalance(node);
		
		// case 1 : LL
		if(balance>1 && data.compareTo(node.getLeftsubtree().getData())<0)
		{
			System.out.println("Tree is left left heavy...");
			return rightRotation(node);
		}
		
		// case 2 : RR
		
		if(balance<-1 && data.compareTo(node.getRightsubtree().getData())>0)
		{
			System.out.println("Tree is right right heavy...");
			return leftRotation(node);
		}
		
		// case 3 : LR
		
		if(balance >1 && data.compareTo(node.getRightsubtree().getData())>0)
		{
			System.out.println("Tree is left right heavy...");
			node.setLeftsubtree(leftRotation(node.getLeftsubtree()));
			return rightRotation(node);
		}
		
		// case 4 : RL
		
		if(balance <-1 && data.compareTo(node.getRightsubtree().getData())<0)
		{
			System.out.println("Tree is right left heavy...");
			node.setRightsubtree(rightRotation(node.getRightsubtree()));
			return leftRotation(node);
		}
		return node;
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		root=delete(root, data);
		
	}

	private Node<T> delete(Node<T> node, T data) {

		if (node == null)
			return node;

		// first we have to look for the node we want to get rid of
		if (data.compareTo(node.getData()) < 0 ) {  // data smaller than given node's data -> go to the left recursively
			node.setLeftsubtree(delete(node.getLeftsubtree(), data));
		} else if (data.compareTo(node.getData()) > 0 ) { // data greater than given node's data -> go to the right recursively
			node.setRightsubtree(delete(node.getRightsubtree(), data));
		} else {  // we have found the node we want to remove !!!

			if (node.getLeftsubtree() == null && node.getRightsubtree() == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if (node.getLeftsubtree() == null) {
				System.out.println("Removing the right child...");
				Node<T> tempNode = node.getRightsubtree();
				node = null;
				return tempNode;
			} else if (node.getRightsubtree() == null) {
				System.out.println("Removing the left child...");
				Node<T> tempNode = node.getLeftsubtree();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node<T> tempNode = getPredecessor(node.getLeftsubtree());

			node.setData(tempNode.getData());
			node.setLeftsubtree(delete(node.getLeftsubtree(), tempNode.getData()));
		}

		node.setHeight(Math.max(height(node.getLeftsubtree()), height(node.getRightsubtree())) + 1);

		// have to check on every delete operation whether the tree has become unbalanced or not !!!
		return settleDeletion(node);
	}

	private Node<T> settleDeletion(Node<T> node) {
		
		int balance = getBalance(node);

		// OK, we know the tree is left heavy BUT it can be left-right heavy or left-left heavy
		if (balance > 1) {
			
			// left right heavy situation: left rotation on parent + right rotation on grandparent
			if (getBalance(node.getLeftsubtree()) < 0) {
				node.setLeftsubtree(leftRotation(node.getLeftsubtree()));
			}

			// this is the right rotation on grandparent ( if left-left heavy, thats single right rotation is needed
			return rightRotation(node);
		}

		// OK, we know the tree is right heavy BUT it can be left-right heavy or right-right heavy
		if (balance < -1) {
			// right - left heavy so we need a right rotation ( on parent!!! ) before left rotation
			if (getBalance(node.getRightsubtree()) > 0) {
				node.setRightsubtree(rightRotation(node.getRightsubtree()));
			}

			// left rotation on grand parent
			return leftRotation(node);
		}

		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {

		Node<T> predecessor = node;

		while (predecessor.getRightsubtree() != null)
			predecessor = predecessor.getRightsubtree();

		return predecessor;
	}

	@Override
	public void traverse() {
		// TODO Auto-generated method stub
		if(root==null) return;
		
		inOrderTraversal(root);
		
	}
	
	private int height(Node<T> node)
	{
		if(node==null)
		{
			return -1;
		}
		return node.getHeight();
		
	}
	
	private int getBalance(Node<T> node)
	{
		if(node==null) return 0;
		
		return height(node.getLeftsubtree())-height(node.getRightsubtree());
		
	}
	
	public Node<T> rightRotation(Node<T> node)
	{
		System.out.println("rotating to the right ...."+node);
		Node<T> tempLeftnode=node.getLeftsubtree();
		Node<T> t=tempLeftnode.getRightsubtree();
		
		tempLeftnode.setRightsubtree(node);
		node.setLeftsubtree(t);
		
        node.setHeight(Math.max(height(node.getLeftsubtree()),height(node.getRightsubtree()))+1);
        tempLeftnode.setHeight(Math.max(height(tempLeftnode.getLeftsubtree()),height(tempLeftnode.getRightsubtree()))+1);
		
        return tempLeftnode;
	}
	
	public Node<T> leftRotation(Node<T> node)
	{
		System.out.println("rotating to the left ...."+node);
		Node<T> tempRightnode=node.getRightsubtree();
		Node<T> t=tempRightnode.getLeftsubtree();
		
		tempRightnode.setLeftsubtree(node);
		node.setRightsubtree(t);
		
        node.setHeight(Math.max(height(node.getLeftsubtree()),height(node.getRightsubtree()))+1);
        tempRightnode.setHeight(Math.max(height(tempRightnode.getLeftsubtree()),height(tempRightnode.getRightsubtree()))+1);
		
        return tempRightnode;
	}

	private void inOrderTraversal(Node<T> node) {
		// TODO Auto-generated method stub
		if(node.getLeftsubtree()!=null)
			inOrderTraversal(node.getLeftsubtree());
		
		System.out.println(node);
		
		if(node.getRightsubtree()!=null)
			inOrderTraversal(node.getRightsubtree());
		
	}

	
}
