package presentation_layer.exceptions;

public class InputInvalidException extends PresentationLayerException{
	private static final String  INPUT_INVALID = "Error :::::: The input provided is invalid.";
	public InputInvalidException(Throwable err) {
		super(INPUT_INVALID, err);
	}
	public InputInvalidException() {
		super(INPUT_INVALID);
	}
}
