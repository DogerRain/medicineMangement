package redistest;
public class AssertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0;i<5;i++)
		{
			System.out.println(i);
		}
		//假设程序不小心多了一句--i;
		--i;
		assert i==5;		
		System.out.println(66666);
	}
}

