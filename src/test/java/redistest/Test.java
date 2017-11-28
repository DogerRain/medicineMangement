package redistest;

class Test {
	synchronized static void sayHello3() {
		while(true){
			System.out.println(1);
		}
	}

	synchronized void getX() {
		while(true)
		System.out.println(2);
	}
	public static void main(String[] args) {
		final Test test=new Test();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Test.sayHello3();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				test.getX();
			}
		}).start();
	}
}
