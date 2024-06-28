package StackLinked;

public class app {
	public static void main(String[] args)
	{
		Stacklink<Integer> st=new Stacklink<Integer>();
		st.push(1);
		st.push(5);
		System.out.println(st.pop());
		st.push(10);
		System.out.println(st.isempty());
	}

}
