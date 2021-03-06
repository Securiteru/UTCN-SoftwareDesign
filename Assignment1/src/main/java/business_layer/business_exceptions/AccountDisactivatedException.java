package business_layer.business_exceptions;

import business_layer.exceptions.BusinessLogicException;

public class AccountDisactivatedException extends BusinessLogicException {
	private static final String  ACCOUNT_INACTIVE = "Error :::::: One of the required accounts is inactive.";
	public AccountDisactivatedException(Throwable err) {
		super(ACCOUNT_INACTIVE, err);
	}
	public AccountDisactivatedException() {
		super(ACCOUNT_INACTIVE);
	}
}
