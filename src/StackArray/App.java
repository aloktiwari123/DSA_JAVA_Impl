package StackArray;

public class App {
	public static void main(String[] args)
	{
		Stack<Integer> st=new Stack<Integer>();
		st.push(17);
		st.push(22);
		st.push(66);
		int n=st.size();
		System.out.println(n);
		System.out.println(st.pop());
		for(int i=0;i<n;i++)
		{
			System.out.println(st.pop());
		}
	}

}
