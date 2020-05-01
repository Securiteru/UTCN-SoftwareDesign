package business_layer.business_exceptions;

import data_source_logic_layer.exceptions.DataMapperException;

public class AmountMissMatchException extends BusinessLogicException {
	private static final String  AMOUNT_MISSMATCH = "Error :::::: The  amount is lower on the sending account than required for the transfer!";
	public AmountMissMatchException(Throwable err) {
		super(AMOUNT_MISSMATCH, err);
	}
	public AmountMissMatchException() {
		super(AMOUNT_MISSMATCH);
	}
}
