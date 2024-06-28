package bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
	
	private Node<T> root;
	
	@Override
	public  void insert(T data)
	{
		if (root==null)
		{
			this.root=new Node<T>(data);
		}
		else
		{
			insertNode(data,root);
		}
	}
	public void insertNode(T newdata,Node<T> node) {
		
		if(newdata.compareTo(node.getData())<0)
		{
			if(node.getLeftchild()!=null)
			{
				insertNode(newdata,node.getLeftchild());
			}else
			{
				Node<T>newNode=new Node<T>(newdata);
				node.setLeftchild(newNode);
			}
		}
		else
		{
			if(node.getRightchild()!=null)
			{
				insertNode(newdata,node.getRightchild());
			}
			else
			{
				Node<T>newNode=new Node<T>(newdata);
				node.setRightchild(newNode);
			}
			
		}
		
		
	}

	@Override
	public void traversal() {
		// TODO Auto-generated method stub
		if(root!=null)
		{
			inordertraversal(root);
		}
	}
	
	public void inordertraversal(Node<T> node)
	{
		if(node.getLeftchild()!=null)
			inordertraversal(node.getLeftchild());
		
		System.out.print(node+"  ---->  ");
		
		if(node.getRightchild()!=null)
			inordertraversal(node.getRightchild());
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		if(root!=null)
			root=delete(root,data);
		
	}
	private Node<T> delete(Node<T> node, T data)
	{
		if(node==null)return node;
		
		if(data.compareTo(node.getData())<0)
		{
			node.setLeftchild(delete(node.getLeftchild(),data));
		}
		else if(data.compareTo(node.getData())>0)
		{
			node.setRightchild(delete(node.getRightchild(),data));
		}
		else
		{
			//node to delete is found
			if(node.getLeftchild()==null && node.getRightchild()==null)
			{
				System.out.println("removing leaf node...");
				return null;
			}
			if(node.getLeftchild()==null)
			{
				System.out.println("removing the single right child...");
				Node<T> tempnode=node.getRightchild();
				node=null;
				return tempnode;
			}
			else if(node.getRightchild()==null)
			{
				System.out.println("removing the single left child...");
				Node<T> tempnode=node.getLeftchild();
				node=null;
				return tempnode;
			}
			
			System.out.println("removing item with two children...");
			Node<T> tempnode=getPredecessor(node.getLeftchild());
			
			node.setData(tempnode.getData());
			node.setLeftchild(delete(node.getLeftchild(),tempnode.getData()));
			
		}
				return node;	
	}
	
	private Node<T> getPredecessor(Node<T> node)
	{
		if(node.getRightchild()!=null)
			return getPredecessor(node.getRightchild());
		System.out.println("Predecessor ----->" +node);
		return node;
	}

	@Override
	public T getmax() {
		
		if(root==null)return null;
		
			return getmaxnode(root);
		
		
	}
	
	public T getmaxnode(Node<T> newnode)
	{
		if(newnode.getRightchild()!=null)
		{
			return getmaxnode(newnode.getRightchild());
		}
		return newnode.getData();
	}

	@Override
	public T getmin() {
		if(root==null)return null;
		return getminnode(root);
		
	}
    
	public T getminnode(Node<T> newnode)
	{
		if(newnode.getLeftchild()!=null)
		{
			return getminnode(newnode.getLeftchild());
		}
		return  newnode.getData();
	}

}
