package LinkedList;

public class Friends implements Comparable<Friends> {
	private String name;
	private int age;
	public Friends(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Friends friend) {
		// TODO Auto-generated method stub
		return Integer.compare(this.age,friend.getAge());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	

}
