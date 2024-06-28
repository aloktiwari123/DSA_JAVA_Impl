package queue;

public class app {
	public static void main(String[] args)
	{
		QueueLink<Integer> q=new QueueLink<Integer>();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		
			System.out.println(q.dqueue());
			System.out.println(q.dqueue());
			System.out.println(q.dqueue());
			
		
		
	}

}
