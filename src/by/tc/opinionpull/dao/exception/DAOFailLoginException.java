package by.tc.opinionpull.dao.exception;

public class DAOFailLoginException extends Exception {
	public DAOFailLoginException() {
		super();
	}

	public DAOFailLoginException(String message) {
		super(message);
	}

	public DAOFailLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOFailLoginException(Throwable cause) {
		super(cause);
	}

	protected DAOFailLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
