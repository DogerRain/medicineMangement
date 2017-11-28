package redistest;

public class StopTest1 {
	public static void main(String[] args) {  
        final Object lock = new Object();  
        try {  
            Thread t0 = new Thread() {  
                public void run() {  
                    try {  
                        synchronized (lock) {  
                            System.out.println("thread->" + getName()  
                                    + " acquire lock.");  
                            sleep(3000);// sleep for 3s  
                            System.out.println("thread->" + getName()  
                                    + " release lock.");  
                        }  
                    } catch (Throwable ex) {  
                        System.out.println("Caught in run: " + ex);  
                        ex.printStackTrace();  
                        while(true){
                        	System.out.println("1111111");
                        }
                    }  
                }  
            };  
  
            Thread t1 = new Thread() {  
                public void run() {  
                    synchronized (lock) {  
                        System.out.println("thread->" + getName()  
                                + " acquire lock.");  
                        while(true){
                        	System.out.println(22222222);
                        }
                    }  
                }  
            };  
  
            t0.start();  
            // Give t time to get going...  
            Thread.sleep(1000);  
            t0.interrupt(); //interrupt可以在sleep时终止线程，stop就随时终止线程
            t1.start();  
        } catch (Throwable t) {  
            System.out.println("Caught in main: " + t);  
            t.printStackTrace();  
        }  
  
    }  
}

