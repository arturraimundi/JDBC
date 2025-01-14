package db;

public class Dbexception extends RuntimeException {
	private static final long serialversionUID = 1L;
	
	public Dbexception(String msg) {
		super(msg);
	}
}
