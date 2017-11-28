package redistest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;
class Student implements Comparable<Student>{
	String name;
	public Student(String name){
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
class Xielou{
	String name;

	public Xielou(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Xielou other = (Xielou) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
public class HashSetTest {
	@Test
	public void demo1(){
		Set<Student> set=new  HashSet();
		set.add(new Student("1"));
		set.add(new Student("2"));
		
		System.out.println(set.size());
		Object lock=new Object();
		
			
				try {
					synchronized (lock) {
					Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		@Test
		public void treeSet(){
			Student s1=new Student("a");
			Student s2=new Student("b");
			TreeSet<Student> treeSet=new TreeSet<>();
			treeSet.add(s1);
			treeSet.add(s2);
			for(Student s:treeSet)
				System.out.println(s.name);
			
		}
		
		@Test
		public void xielou(){
			Xielou x1=new Xielou("a"),x2=new Xielou("a");
			System.out.println(x1.hashCode());
			System.out.println(x2.hashCode());
			
			Set<Xielou> set=new HashSet<>();
			set.add(x1);
			set.add(x2);
			System.out.println(set.size());
			x1.name="jb";
			set.remove(x1);
			System.out.println(set.size());
			set.remove(x2);
			System.out.println(set.size());
			
		}
	
	
}
