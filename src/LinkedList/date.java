package LinkedList;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

public class date {
	
	public static void main(String[] args)
	{
		
	Date today=new Date();
	SimpleDateFormat dateformat=new SimpleDateFormat("dd-MMM-yy");
	System.out.println(dateformat.format(today));
	Calendar c=Calendar.getInstance();
	System.out.println(c);
    Date d=c.getTime();
	System.out.println(d);
	LocalTime time = LocalTime.now();
	System.out.println(time);
	List<Integer> a=Arrays.asList(1,2,3,4,5,5,6,6);
	Set<Integer> n=new HashSet<>(a);
	System.out.println(a);
	System.out.println(n);
	TreeMap<Integer, String> treeMap = new TreeMap<>();
	treeMap.put(10,"ten");
	treeMap.put(4,"four");
	treeMap.put(1,"one");
	treeMap.put(12,"twelve");
	System.out.println(treeMap);
	for(Entry<Integer,String>e:treeMap.entrySet())
	{
		System.out.println(e);
	}
	
	}
}