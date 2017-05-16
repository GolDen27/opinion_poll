package by.tc.opinionpull.dao.exception;

public class DAODuplicateException extends Exception {
	public DAODuplicateException() {
		super();
	}

	public DAODuplicateException(String message) {
		super(message);
	}

	public DAODuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAODuplicateException(Throwable cause) {
		super(cause);
	}

	protected DAODuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
