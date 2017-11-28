package redistest;

import java.io.IOException;

public class GarbageTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			gcTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("has exited gcTest!");
		System.in.read();
		System.in.read();		
		System.out.println("out begin gc!");		
		for(int i=0;i<100;i++)
		{
			System.gc();
			System.in.read();	
			System.in.read();	
		}
	}

	private static void gcTest() throws IOException {
		System.in.read();
		System.in.read();		
		Person p1 = new Person();
		System.in.read();
		System.in.read();		
		Person p2 = new Person();
		p1.setMate(p2);
		p2.setMate(p1);
		System.out.println("before exit gctest!");
		System.in.read();
		System.in.read();	
//		p1=null;
//		p2=null;
		System.gc();
		System.out.println(p1);
		System.out.println("exit gctest!");
	}

	private static class Person
	{
		byte[] data = new byte[20000000];
		Person mate = null;
		public void setMate(Person other)
		{
			mate = other;
		}
		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
			System.out.println("Im realese");
		}
		
	}
}
