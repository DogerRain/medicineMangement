package exception;

public class YpkcxxNotFind extends RuntimeException{
	public YpkcxxNotFind(int ypbm){
		super("YpkcxxNotFind:"+ypbm);
	}
}
