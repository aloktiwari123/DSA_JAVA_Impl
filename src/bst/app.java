package bst;

public class app {
	public static void main(String args[])
	{
		Tree<Integer>bst=new BinarySearchTree<Integer>();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		
		
		
		bst.delete(10);
		bst.traversal();
	}

}
