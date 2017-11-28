package exception;

public class ZgxxNotFind extends RuntimeException{
	public ZgxxNotFind(int zgbm){
		super("ZgxxNotFind:"+zgbm);
	}
}
