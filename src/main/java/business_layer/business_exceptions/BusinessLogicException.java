package business_layer.business_exceptions;

public class BusinessLogicException extends Exception{
	public BusinessLogicException(String s,Throwable err) {
		super(s, err);
	}
	public BusinessLogicException(String s) {
		super(s);
	}
}
