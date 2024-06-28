package Dijkastra;
import java.util.Stack;
public class DijkastraInterpreter {
	private Stack<String> operationStack;
	private Stack<Double> valueStack;
	
	public DijkastraInterpreter()
	{
		this.operationStack=new Stack<>();
		this.valueStack=new Stack<>();
	}
	public void interpreter(String Exp)
	{
		String[] exp=Exp.split(" ");
		for(String s:exp)
		{
			if(s.equals("(")) {
				
			}
			else if(s.equals("+"))
			{
				this.operationStack.push(s);
			}
			else if(s.equals("*"))
			{
				this.operationStack.push(s);
			}
			else if(s.equals(")")){
				String operation=this.operationStack.pop();
				
				if(operation.equals("+"))
				{
					this.valueStack.push(this.valueStack.pop()+this.valueStack.pop());
				}
				if(operation.equals("*"))
				{
					this.valueStack.push(this.valueStack.pop()*this.valueStack.pop());
				}
			}
			else
			{
				this.valueStack.push(Double.parseDouble(s));
			}
		}
	}
	public void result()
	{
		System.out.print(this.valueStack.pop());
	}

}
