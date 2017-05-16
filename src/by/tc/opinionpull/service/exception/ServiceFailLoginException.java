package by.tc.opinionpull.service.exception;

public class ServiceFailLoginException extends Exception {
	public ServiceFailLoginException() {
		super();
	}

	public ServiceFailLoginException(String message) {
		super(message);
	}

	public ServiceFailLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceFailLoginException(Throwable cause) {
		super(cause);
	}

	protected ServiceFailLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
