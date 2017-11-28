package redistest;

public class StopTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t=new Thread(){
			//如果是new Thread(new Runnable( public synchronized void run ){})所不是thread的
			@Override
			public synchronized void run() {
				// TODO Auto-generated method stub
				 for (int i = 0; i < 100000; i++)  
                     System.out.println("runing.." + i);  
			}
		};
		t.start();
		Thread.sleep(100);
		t.stop();

	}

}
