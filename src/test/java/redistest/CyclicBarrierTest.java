package redistest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<List<String>> allList=new ArrayList<>();
		final Hotel hotel=new Hotel(allList);
		ExecutorService pool=Executors.newCachedThreadPool();
		for(int i=1;i<=1000;++i)
			pool.execute(new User(String.valueOf(i), hotel));
		pool.shutdown();
		for(int i=0;i<allList.size();++i)
		{
			List<String > l=allList.get(i);
			for(int j=0;j<l.size();++j)
				System.out.print(l.get(j)+",");
			System.out.println();
		}
	}

}
class Hotel
{
	List<String> userList=new ArrayList<>();
	 List<List<String>> allList;
	 
	public Hotel(List<List<String>> allList) {
		super();
		this.allList = allList;
	}

	public synchronized void come(String name){
		userList.add(name);
		if(userList.size()==5){
			allList.add(userList);
			userList=new ArrayList<>();
			
		}
		
		
		
	}
}
class User implements Runnable{
	String name;
	Hotel hotel;
	

	public User(String name, Hotel hotel){
		super();
		this.name = name;
		this.hotel=hotel;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		hotel.come(name );
	}
	
}
