package business_layer.business_exceptions;

import data_source_logic_layer.exceptions.DataMapperException;

public class AmountMissMatchException extends BusinessLogicException {
	private static final String  AMOUNT_MISSMATCH = "ERROR :::::: YOUR AMOUNT IS LOWER ON THE SENDING ACCOUNT THAN REQUIRED";
	public AmountMissMatchException(Throwable err) {
		super(AMOUNT_MISSMATCH, err);
	}
	public AmountMissMatchException() {
		super(AMOUNT_MISSMATCH);
	}
}
