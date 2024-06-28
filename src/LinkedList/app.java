package LinkedList;

public class app {
	public static void main(String[] args)
	{
		List<Friends> list=new Linked<Friends>();
		list.insert(new Friends("Hritik",27));
		list.insert(new Friends("Akash",23));
		list.insert(new Friends("Himanshu",22));
		list.insert(new Friends("Alok",21));
		Friends p=new Friends("hghg",5);
		list.insert(p);
		list.traverse();
		list.remove(p);
		list.traverse();
		Linked<Integer> lin=new Linked<Integer>();
		lin.insert(1);
		lin.insert(2);
		lin.insert(5);
		lin.traverse();
		lin.remove(2);
		lin.traverse();
		
		
	}

}
