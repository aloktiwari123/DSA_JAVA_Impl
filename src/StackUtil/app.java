package StackUtil;
import java.util.Stack;

public class app {
	public static void main(String[] args)
	{
		Stack<Integer> st=new Stack<Integer>();
		st.push(10);
		st.push(12);
		st.push(22);
		st.push(55);
		for(Integer i:st)
		{
			System.out.println(i);
		}
		
	}

}
