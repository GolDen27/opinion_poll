package by.tc.opinionpull.service.exception;

public class ServiceDuplicateException extends Exception {
	public ServiceDuplicateException() {
		super();
	}

	public ServiceDuplicateException(String message) {
		super(message);
	}

	public ServiceDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceDuplicateException(Throwable cause) {
		super(cause);
	}

	protected ServiceDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
