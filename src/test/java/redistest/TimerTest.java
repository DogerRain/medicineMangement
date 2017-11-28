package redistest;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer=new Timer("tt");
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("ok");
				
			}
		}, 1000);
	//	timer.cancel();
	//	timer.cancel();
		
	}

}
