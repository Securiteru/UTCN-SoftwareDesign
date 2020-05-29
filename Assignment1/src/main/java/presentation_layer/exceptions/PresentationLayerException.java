package presentation_layer.exceptions;

public class PresentationLayerException extends Exception{
	public PresentationLayerException(String s,Throwable err) {
		super(s, err);
	}
	public PresentationLayerException(String s) {
		super(s);
	}
}
