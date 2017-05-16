package by.tc.opinionpull.service.validate;

public final class ValidateString {
	private ValidateString() {}

	public final static String LOGIN = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
	public final static String PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$";
	public final static String WORD_WITH_BIG_LETTER = "^[A-ZА-Я][a-zа-я]{1,}$";
	public final static String WORD = "^[A-zА-я]{1,}$";
	public final static String TEXT = "^[A-zА-я\\s.,!?:…]{1,}$";
	public final static String POSITIVE_NUMBER = "^\\d+$";
	public final static String POSITIVE_REAL_NUMBER = "^[\\d]+[\\.]*[\\d]*$";
	public final static String NUMBER = "^\\-*\\d+$";
	public final static String BOOLEAN_NUMBER = "^[01]$";
}
