package business_layer.exceptions;

public class CurrencyMissmatchException  extends BusinessLogicException{
	private static final String CURRENCY_MISMATCH = "Error :::::: The accounts do not have the same currency!";
	public CurrencyMissmatchException(Throwable err) {
		super(CURRENCY_MISMATCH, err);
	}
	public CurrencyMissmatchException() {
		super(CURRENCY_MISMATCH);
	}
}
