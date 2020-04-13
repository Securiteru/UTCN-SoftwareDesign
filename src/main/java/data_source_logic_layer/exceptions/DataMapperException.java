package data_source_logic_layer.exceptions;

public class DataMapperException extends Throwable {
	public DataMapperException(String s,Throwable err) {
		super(s, err);
	}
	public DataMapperException(String s) {
		super(s);
	}
}
