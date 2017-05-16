package by.tc.opinionpull.service.exception;

public class ServiseIllegalArgumentException extends Exception {
	public ServiseIllegalArgumentException() {
		super();
	}

	public ServiseIllegalArgumentException(String message) {
		super(message);
	}

	public ServiseIllegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiseIllegalArgumentException(Throwable cause) {
		super(cause);
	}

	protected ServiseIllegalArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
