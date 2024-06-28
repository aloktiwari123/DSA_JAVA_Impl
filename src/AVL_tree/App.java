package AVL_tree;

public class App {
	
	public static void main(String[] args)
	{
		AVL_Tree<Integer> tree=new AVL_Tree<>();
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		tree.insert(20);
		tree.insert(40);
		//System.out.print(tree);
		tree.traverse();
		tree.delete(30);
		tree.traverse();
	}

}
