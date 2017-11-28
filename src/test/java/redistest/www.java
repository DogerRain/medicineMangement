package redistest;

import org.junit.Test;

public class www {
	public int xx(){
		try{
			return 1;
		}finally{
			return 2;
		}
	}
	@Test
	public void demo1(){
		System.out.println(xx());
	}
}
