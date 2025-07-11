package io;


//Si queremos una excepcion catched usamos hijo de exception, si no que herede de runtime y añadiremos constructores de superClass.
public class LecturaTecladoException extends RuntimeException {


	public LecturaTecladoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LecturaTecladoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LecturaTecladoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LecturaTecladoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LecturaTecladoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
