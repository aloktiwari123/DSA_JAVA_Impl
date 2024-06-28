package Dijkastra;

public class app {
	public static void main(String[] args)
	{
		DijkastraInterpreter dj=new DijkastraInterpreter();
		dj.interpreter("( ( 2 + 5 ) * ( 4 + 3 ) )");
		dj.result();
	}

}
