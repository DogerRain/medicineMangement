package exception;

public class GysNotFind extends RuntimeException{
	public GysNotFind(int ypbm){
		super("GysFind:"+ypbm);
	}
}
