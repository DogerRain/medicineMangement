package redistest;

public class XC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Thread.currentThread().interrupt();//由false变true
	        System.out.println("stop 1??" + Thread.currentThread().interrupted());//变回true
	        System.out.println("stop 2??" + Thread.currentThread().interrupted());
	        System.out.println("stop 3??" + Thread.currentThread().interrupted());

	        System.out.println("End");
	}

}
