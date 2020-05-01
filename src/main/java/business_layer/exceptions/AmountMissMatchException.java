package business_layer.exceptions;

public class AmountMissMatchException extends BusinessLogicException {
	private static final String  AMOUNT_MISSMATCH = "Error :::::: The  amount is lower on the sending account than required for the transfer!";
	public AmountMissMatchException(Throwable err) {
		super(AMOUNT_MISSMATCH, err);
	}
	public AmountMissMatchException() {
		super(AMOUNT_MISSMATCH);
	}
}
