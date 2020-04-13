package business_layer.business_exceptions;

import data_source_logic_layer.exceptions.DataMapperException;

public class AccountDisactivatedException extends BusinessLogicException {
	private static final String  ACCOUNT_INACTIVE = "ERROR :::::: YOUR ACCOUNT IS DISACTIVATED";
	public AccountDisactivatedException(Throwable err) {
		super(ACCOUNT_INACTIVE, err);
	}
	public AccountDisactivatedException() {
		super(ACCOUNT_INACTIVE);
	}
}
